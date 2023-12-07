package com.example.notif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notif.databinding.FragmentNotiListBinding
import com.example.notif.model.NotiViewModel
import com.example.notif.model.NotificationModelFactory

class NotiList : Fragment() {
    private lateinit var binding : FragmentNotiListBinding
    private val sharedViewModel: NotiViewModel by activityViewModels {
        NotificationModelFactory((activity?.application as NotiApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentNotiListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        val button1 = binding!!.bottomButton
        button1.setOnClickListener{
            findNavController().navigate(R.id.action_notiList_to_homeFragment)
        }
        return fragmentBinding.root
    }
}