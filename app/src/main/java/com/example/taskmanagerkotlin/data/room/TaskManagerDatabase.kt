package com.example.taskmanagerkotlin.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.taskmanagerkotlin.data.TaskManagerSchema
import com.example.taskmanagerkotlin.model.User

@Database(entities = [User :: class],version = TaskManagerSchema.VERSION)
@TypeConverters(value = [Converter::class])
abstract class TaskManagerDatabase : RoomDatabase() {

    abstract fun getUserDAo():UserDAO
}