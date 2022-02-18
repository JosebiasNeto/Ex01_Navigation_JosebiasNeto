package com.example.navigationcomponet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigationcomponet.databinding.FragmentQuestionsBinding

class FirstFragment: Fragment() {

    private lateinit var binding: FragmentQuestionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentQuestionsBinding.inflate(inflater, container, false)

        binding.tvQuestion.text = "Qual o valor da taxa de assinatura da Google Play para desenvolvedores?"

        binding.firstAnswer.text = "US$ 25 por ano"
        binding.secondAnswer.text = "US$ 99 por ano"
        binding.thirdAnswer.text = "US$ 25 - taxa unica"
        binding.fourthAnswer.text = "US$ 299 por ano"

        binding.btnConfirm.setOnClickListener {
            val answer = Bundle()
            if(binding.radioGroup.checkedRadioButtonId == 2){
                answer.putInt("answer", 1)
            } else {
                answer.putInt("answer", 0)
            }
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment, answer)
        }

        return binding.root
    }
}