package com.itis.studenthelper

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.studenthelper.databinding.FragmentDeadlineBinding

class DeadlineFragment : Fragment(R.layout.fragment_deadline) {

    private var _binding: FragmentDeadlineBinding? = null
    private val binding get() = _binding!!

    private var adapter: DeadlineAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDeadlineBinding.bind(view)

        adapter = DeadlineAdapter(TaskRepository.tasks)
        binding.rvDeadline.adapter = adapter

        with(binding){
            btnBack.setOnClickListener{
                findNavController().navigate(R.id.action_deadlineFragment_to_cardsFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}