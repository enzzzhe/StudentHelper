package com.itis.studenthelper

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.studenthelper.databinding.FragmentCardsBinding

class CardsFragment: Fragment(R.layout.fragment_cards) {
    private var _binding: FragmentCardsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCardsBinding.bind(view)

        with(binding){
            card.setOnClickListener{
                findNavController().navigate(R.id.action_cardsFragment_to_deadlineFragment)
            }
            imageButton.setOnClickListener {
                findNavController().navigate(R.id.action_cardsFragment_to_dateDialog)
            }
            imageButton1.setOnClickListener {
                findNavController().navigate(R.id.action_cardsFragment_to_menuDialog)
            }
        }
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}