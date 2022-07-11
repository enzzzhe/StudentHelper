package com.itis.studenthelper

import java.util.*

data class TaskForDay(
    val id: Int,
    val action:String,
    val time_from: Calendar,
    val time_to:Calendar,
)