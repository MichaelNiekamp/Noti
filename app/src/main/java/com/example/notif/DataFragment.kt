package com.example.notif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notif.databinding.FragmentDataBinding
import com.example.notif.model.NotiViewModel

class DataFragment : Fragment() {

    private lateinit var binding : FragmentDataBinding
    private val sharedViewModel: NotiViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentDataBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        val button1 = binding!!.datanextButton
        button1.setOnClickListener{
            val userInput: String = binding.titleEditText.text.toString()
            val userInput2: String = binding.descriptionEditText.text.toString()
            sharedViewModel.setTitle(userInput)
            sharedViewModel.setDesc(userInput2)
            findNavController().navigate(R.id.action_dataFragment_to_dateFragment)
        }

        val button2 = binding!!.datacancelButton
        button2.setOnClickListener{
            findNavController().navigate(R.id.action_dataFragment_to_homeFragment)
        }

        return fragmentBinding.root
    }

}