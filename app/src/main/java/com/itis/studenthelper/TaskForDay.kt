package com.itis.studenthelper

import java.util.*

class TaskForDay(
    val id: Int,
    val action:String,
    val time_from: Calendar,
    val time_to:Calendar,
){
    fun getValue():Int{
        var minTo = (this.time_to.get(Calendar.HOUR_OF_DAY) * 60) + this.time_to.get(Calendar.MINUTE)
        var minFrom = (this.time_from.get(Calendar.HOUR_OF_DAY) * 60) + this.time_from.get(Calendar.MINUTE)
        return minTo - minFrom
    }
}
