package com.itis.studenthelper

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.studenthelper.databinding.SecondFragmentDeadlineBinding

class SecondDeadlineFragment : Fragment(R.layout.second_fragment_deadline) {

    private var _binding: SecondFragmentDeadlineBinding? = null
    private val binding get() = _binding!!

    private var adapter: DeadlineAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = SecondFragmentDeadlineBinding.bind(view)

        adapter = DeadlineAdapter(TaskRepository.tasks)
        binding.rvDeadline2.adapter = adapter

        with(binding){
            btnBack2.setOnClickListener{
                findNavController().navigate(R.id.action_secondDeadlineFragment_to_cardsFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}