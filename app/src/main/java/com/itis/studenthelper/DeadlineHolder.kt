package com.itis.studenthelper

import androidx.recyclerview.widget.RecyclerView
import com.itis.studenthelper.databinding.ItemExerciseBinding

class DeadlineHolder(
    private val binding: ItemExerciseBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(task: Task) {
        with(binding) {
            checkBox.text = task.name
        }
    }
}
