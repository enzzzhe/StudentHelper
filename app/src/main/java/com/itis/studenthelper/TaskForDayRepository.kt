package com.itis.studenthelper

 import java.util.*


object TaskForDayRepository {
    var actualId = 0
    var taskArray = arrayListOf<TaskForDay>(
    )
    fun addTask(taskForDay:TaskForDay){
        taskArray.add(taskForDay)
    }
}