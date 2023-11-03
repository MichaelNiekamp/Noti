package com.example.notif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notif.model.NotiViewModel


class DateFragment : Fragment() {
    private val sharedViewModel: NotiViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_date, container, false)


        val button1 = view.findViewById<Button>(R.id.datenextButton)
        button1.setOnClickListener{
            findNavController().navigate(R.id.action_dateFragment_to_summaryFragment)
        }

        val button2 = view.findViewById<Button>(R.id.datecancelButton)
        button2.setOnClickListener{
            findNavController().navigate(R.id.action_dateFragment_to_homeFragment)
        }
        return view
    }


}