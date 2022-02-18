package com.example.navigationcomponet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigationcomponet.databinding.FragmentQuestionsBinding

class ThirdFragment:Fragment() {

    private lateinit var binding: FragmentQuestionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentQuestionsBinding.inflate(inflater, container, false)

        binding.tvQuestion.text = "Qual o sistema operacional mais utilizado no mundo?"

        binding.firstAnswer.text = "Windows"
        binding.secondAnswer.text = "Android"
        binding.thirdAnswer.text = "IOS"
        binding.fourthAnswer.text = "OS X"

        binding.btnConfirm.setOnClickListener {
            val lastAnswer: Int = arguments!!.get("answer") as Int
            var result = Bundle()
            if(binding.firstAnswer.isChecked){
                result.putInt("result", 1 + lastAnswer)
            } else {
                result.putInt("result", lastAnswer)
            }
            if(result.getInt("result") > 1){
                it.findNavController().navigate(R.id.action_thirdFragment_to_correctAnswerFragment, result)
            } else {
                it.findNavController().navigate(R.id.action_thirdFragment_to_wrongAnswerFragment, result)
            }
        }

        return binding.root
    }
}