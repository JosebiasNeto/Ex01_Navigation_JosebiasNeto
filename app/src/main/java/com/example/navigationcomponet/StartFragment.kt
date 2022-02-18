package com.example.navigationcomponet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigationcomponet.databinding.FragmentStartBinding

class StartFragment:Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)

        binding.btnStart.setOnClickListener {
            it.findNavController().navigate(R.id.action_startFragment_to_firstFragment)
        }

        return binding.root
    }
}