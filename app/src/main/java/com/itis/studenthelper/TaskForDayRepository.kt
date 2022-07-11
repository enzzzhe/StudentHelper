package com.itis.studenthelper

 import java.util.*
 import kotlin.collections.ArrayList


object TaskForDayRepository {
    var actualId = 1
    var taskArray = arrayListOf<TaskForDay>(
        TaskForDay(0,"Сон", createCalendar(1,30), createCalendar(8,30))
    )

    fun addTask(taskForDay:TaskForDay){
        taskArray.add(taskForDay)
    }

    fun getFreeTime():Int{
        var time = 0
        chooseTask().forEach {
            time += it.getValue()
        }
        return 60*24 - time
    }

    fun chooseTask(): List<TaskForDay> {
        var calendar = Calendar.getInstance()
        return this.taskArray.filter {
            (it.time_from.get(Calendar.DATE) == calendar.get(Calendar.DATE)) &&
                    (it.time_from.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))&&
                    (it.time_from.get(Calendar.YEAR) == calendar.get(Calendar.YEAR))
        }.sortedBy {
            it.time_from.get(Calendar.HOUR_OF_DAY)
        }
    }

    fun createCalendar(hour:Int,minute:Int):Calendar{
        var calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY,hour)
        calendar.set(Calendar.MINUTE,minute)
        return calendar
    }
}