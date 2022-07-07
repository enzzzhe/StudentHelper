package com.example.studenthelper

import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.databinding.ItemTaskBinding

class DeadlineHolder(
    val binding: ItemTaskBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(task: Task){
        with(binding){
            checkBox.text = task.name
        }
    }
}