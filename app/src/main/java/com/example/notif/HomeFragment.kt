package com.example.notif

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val button = view.findViewById<Button>(R.id.home_button)
        val button2 = view.findViewById<Button>(R.id.second_button)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_dataFragment)
        }
        button2.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_notiList)
        }
        return view
    }


}
