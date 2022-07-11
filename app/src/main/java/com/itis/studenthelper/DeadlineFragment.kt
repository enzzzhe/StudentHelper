package com.itis.studenthelper

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.itis.studenthelper.databinding.FragmentDeadlineBinding

class DeadlineFragment : Fragment(R.layout.fragment_deadline) {

    private var _binding: FragmentDeadlineBinding? = null
    private val binding get() = _binding!!

    private var adapter: DeadlineAdapter? = null

    lateinit var checkBox: CheckBox
    lateinit var percentOfPlan: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDeadlineBinding.bind(view)

        adapter = DeadlineAdapter(TaskRepository.tasks)
        binding.rvDeadline.adapter = adapter

        countPercent()
    }

    fun countPercent(){
        var count = 0
        var percent = 0
        percentOfPlan = binding.tvPercent

        if (checkBox.isChecked){
            count += 1
        }
        percent = 100 * count / TaskRepository.tasks.size
        percentOfPlan.append("Выполнено $percent% плана")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}