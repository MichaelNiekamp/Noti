package com.example.notif

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notif.databinding.FragmentDateBinding
import com.example.notif.model.NotiViewModel
import com.example.notif.model.NotificationModelFactory
import java.util.Calendar
import java.util.Date


class DateFragment : Fragment() {
    private var binding : FragmentDateBinding? = null
    private val sharedViewModel: NotiViewModel by activityViewModels {
        NotificationModelFactory((activity?.application as NotiApplication).repository)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        createNotificationChannel()
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentDateBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        val button1 = binding!!.datenextButton
        button1.setOnClickListener{
            scheduleNotification()
            findNavController().navigate(R.id.action_dateFragment_to_summaryFragment)
        }

        val button2 = binding!!.datecancelButton
        button2.setOnClickListener{
            findNavController().navigate(R.id.action_dateFragment_to_homeFragment)
        }
        return fragmentBinding.root
    }

    private fun getTime(): Long {
        val minute = binding!!.timer.minute
        val hour = binding!!.timer.hour
        val day = binding!!.dater.dayOfMonth
        val month = binding!!.dater.month
        val year = binding!!.dater.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    @SuppressLint("ScheduleExactAlarm")
    private fun scheduleNotification(){
        val intent = Intent(activity?.applicationContext, Notifs::class.java)
        val title = sharedViewModel.title.value.toString()
        val message = sharedViewModel.desc.value.toString()
        intent.putExtra(messageExtra, message)
        intent.putExtra(titleExtra, title)
        val pendingIntent = PendingIntent.getBroadcast(activity?.applicationContext, notificationID, intent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = activity?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, time, pendingIntent)
        showAlert(time, title, message)
    }

    private fun showAlert(time: Long, title: String, message: String) {
        val date = Date(time)

        val dateFormat = DateFormat.getLongDateFormat(activity?.applicationContext)
        val timeFormat = DateFormat.getTimeFormat(activity?.applicationContext)

        sharedViewModel.setDate(dateFormat.format(date))
        sharedViewModel.setTime(timeFormat.format(time))
        AlertDialog.Builder(activity)
            .setTitle("Noti Scheduled")
            .setMessage("Title: "+title+"\nMessage: "+message+"\nAt: "+dateFormat.format(date)+" "+timeFormat.format(time))
            .setPositiveButton("Okay"){_,_ ->}.show()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(){
        val name = "Noti Channel"
        val desc = "Description of Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID, name, importance)
        channel.description = desc
        val notificationManager = activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

}