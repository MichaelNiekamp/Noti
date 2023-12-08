package com.example.notif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notif.databinding.FragmentNotiListBinding
import com.example.notif.model.NotiViewModel
import com.example.notif.model.NotificationModelFactory

class NotiList : Fragment() {
    private lateinit var binding : FragmentNotiListBinding
    private val sharedViewModel: NotiViewModel by activityViewModels {
        NotificationModelFactory((activity?.application as NotiApplication).repository)
    }

    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var allNotifications: List<Notification>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentNotiListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        val button1 = binding!!.bottomButton

//        allNotifications = sharedViewModel.getNotis()

        button1.setOnClickListener{
            findNavController().navigate(R.id.action_notiList_to_homeFragment)
        }
        return fragmentBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allNotifications = sharedViewModel.getNotis()
        adapter = MyAdapter(allNotifications)
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }
}