package com.example.navigationcomponet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigationcomponet.databinding.FragmentQuestionsBinding

class SecondFragment: Fragment() {

    private lateinit var binding: FragmentQuestionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentQuestionsBinding.inflate(inflater, container, false)

        binding.tvQuestion.text = "Qual a versao do Android que introduziu o Material Design?"

        binding.firstAnswer.text = "KitKat"
        binding.secondAnswer.text = "Oreo"
        binding.thirdAnswer.text = "Jelly Bean"
        binding.fourthAnswer.text = "Lollipop"

        binding.btnConfirm.setOnClickListener {
            val lastAnswer: Int = arguments!!.get("answer") as Int
            val answer = Bundle()
            if(binding.fourthAnswer.isChecked){
                val result = 1 + lastAnswer
                answer.putInt("answer", result)
            } else {
                answer.putInt("answer", lastAnswer)
            }
            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, answer)
        }

        return binding.root
    }
}