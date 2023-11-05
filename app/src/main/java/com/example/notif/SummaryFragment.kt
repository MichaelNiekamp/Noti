package com.example.notif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notif.databinding.FragmentSummaryBinding
import com.example.notif.model.NotiViewModel

class SummaryFragment : Fragment() {
    private var binding : FragmentSummaryBinding? = null
    private val sharedViewModel: NotiViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_summary, container, false)

        val button1 = view.findViewById<Button>(R.id.summarynextButton)
        button1.setOnClickListener{
            findNavController().navigate(R.id.action_summaryFragment_to_homeFragment)
        }

        val button2 = view.findViewById<Button>(R.id.summarycancelButton)
        button2.setOnClickListener{
            findNavController().navigate(R.id.action_summaryFragment_to_homeFragment)
        }

        return view
    }


}