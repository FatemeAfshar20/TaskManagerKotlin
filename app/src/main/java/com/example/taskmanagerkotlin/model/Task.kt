package com.example.taskmanagerkotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskmanagerkotlin.data.TaskManagerSchema
import com.example.taskmanagerkotlin.data.TaskManagerSchema.Task.TaskColumns

@Entity(tableName = TaskManagerSchema.Task.NAME)
class Task() {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TaskColumns.ID)
    var id: Int? = null

    @ColumnInfo(name = TaskColumns.TITLE)
    var title: String? = null

    @ColumnInfo(name = TaskColumns.CONTENT)
    var description: String? = null

    @ColumnInfo(name = TaskColumns.STATE)
    var state: String = "TODO"

    @ColumnInfo(name = TaskColumns.USER_ID)
    var userId: Int = 5
}