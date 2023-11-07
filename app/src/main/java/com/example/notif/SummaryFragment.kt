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

class SummaryFragment : Fragment() {
    private lateinit var binding : FragmentSummaryBinding
    private val sharedViewModel: NotiViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        val button1 = binding!!.summarynextButton
        // Initialize your shared ViewModel

        // Bind the ViewModel to the layout
        binding.viewModel = sharedViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        button1.setOnClickListener{
            findNavController().navigate(R.id.action_summaryFragment_to_homeFragment)
        }

        return fragmentBinding.root
    }

}