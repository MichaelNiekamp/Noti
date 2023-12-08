package com.example.notif

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notif.databinding.FragmentHomeBinding
import com.example.notif.model.NotiViewModel
import com.example.notif.model.NotificationModelFactory


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val sharedViewModel: NotiViewModel by activityViewModels {
        NotificationModelFactory((activity?.application as NotiApplication).repository)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        val button = binding.homeButton
        val button2 = binding.secondButton
        sharedViewModel.setTitle("Initialize")

        button.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_dataFragment)
        }
        button2.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_notiList)
        }
        return fragmentBinding.root
    }


}
