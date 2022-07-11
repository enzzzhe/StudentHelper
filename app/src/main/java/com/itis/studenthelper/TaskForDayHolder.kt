package com.itis.studenthelper

import android.icu.util.Calendar
import androidx.recyclerview.widget.RecyclerView
import com.itis.studenthelper.databinding.ItemTaskBinding

class TaskForDayHolder(private val binding: ItemTaskBinding,) : RecyclerView.ViewHolder(binding.root) {

    fun OnBind(taskForDay: TaskForDay) {
        with(binding){
            tiTime.text = "${taskForDay.time_from.get(Calendar.HOUR)}:${taskForDay.time_from.get(Calendar.MINUTE)}-${taskForDay.time_to.get(Calendar.HOUR)}:${taskForDay.time_to.get(Calendar.MINUTE)}"
            tiTask.text = taskForDay.action
        }
    }
}