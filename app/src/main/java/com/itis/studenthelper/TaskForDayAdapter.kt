package com.itis.studenthelper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itis.studenthelper.databinding.ItemTaskBinding
import java.util.*
import kotlin.collections.ArrayList

class TaskForDayAdapter (private var taskList: kotlin.collections.ArrayList<TaskForDay>) : RecyclerView.Adapter<TaskForDayHolder>(){

    private var calendar = Calendar.getInstance()
    private var list = TaskForDayRepository.chooseTask()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskForDayHolder = TaskForDayHolder(
        ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TaskForDayHolder, position: Int) {
        holder.OnBind(list.get(position)  )
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList : ArrayList<TaskForDay>){
        val calendar = Calendar.getInstance()
        list = TaskForDayRepository.chooseTask()
        notifyDataSetChanged()
    }
}