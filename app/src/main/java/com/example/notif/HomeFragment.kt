package com.example.notif

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notif.databinding.FragmentHomeBinding
import com.example.notif.model.NotiViewModel


class HomeFragment : Fragment() {
    private var binding : FragmentHomeBinding? = null
    private val sharedViewModel: NotiViewModel by activityViewModels()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val button = view.findViewById<Button>(R.id.home_button)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_dataFragment)
        }
        return view
    }


}
