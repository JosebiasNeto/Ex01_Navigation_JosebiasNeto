package com.example.navigationcomponet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigationcomponet.databinding.FragmentResultBinding

class WrongAnswerFragment:Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentResultBinding.inflate(inflater, container, false)

        val result = arguments!!.get("result") as Int
        val txtResult = "Tente novamente! Voce acertou $result das 3 perguntas."
        binding.tvResult.text = txtResult

        binding.btnFinish.setOnClickListener {
            it.findNavController().navigate(R.id.action_back_to_start_fragment)
        }

        return binding.root
    }
}