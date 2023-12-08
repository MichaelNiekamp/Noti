package com.example.notif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notif.databinding.FragmentSummaryBinding
import com.example.notif.model.NotiViewModel
import com.example.notif.model.NotificationModelFactory

class SummaryFragment : Fragment() {
    private lateinit var binding : FragmentSummaryBinding
    private val sharedViewModel: NotiViewModel by activityViewModels {
        NotificationModelFactory((activity?.application as NotiApplication).repository)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        val button1 = binding!!.summarynextButton

        // Bind the ViewModel to the layout
        binding.viewModel = sharedViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        button1.setOnClickListener{
            // save notification to database
            val notificationInstance = Notification(
                notiTitle = sharedViewModel.title.value.toString(),
                notiDesc = sharedViewModel.desc.value.toString(),
                notiDate = sharedViewModel.date.value.toString(),
                notiTime = sharedViewModel.time.value.toString()
            )
            sharedViewModel.addNoti(notificationInstance)
            // navigate to home fragment
            findNavController().navigate(R.id.action_summaryFragment_to_homeFragment)
        }

        return fragmentBinding.root
    }

}