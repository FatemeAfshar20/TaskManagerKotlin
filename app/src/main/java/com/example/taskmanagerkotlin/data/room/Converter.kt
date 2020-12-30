package com.example.taskmanagerkotlin.data.room

import androidx.room.TypeConverter
import java.util.*

object Converter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

/*    @TypeConverter
    fun taskStateToStr(taskState: TaskState): String {
        return taskState.toString()
    }

    @TypeConverter
    fun strToTaskState(str: String?): TaskState? {
        return when (str) {
            "TODO" -> TaskState.TODO
            "DONE" -> TaskState.DONE
            "DOING" -> TaskState.DOING
            else -> null
        }
    }*/
}