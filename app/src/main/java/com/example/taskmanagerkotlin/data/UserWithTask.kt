package com.example.taskmanagerkotlin.data

import androidx.room.Embedded
import androidx.room.Relation
import com.example.taskmanagerkotlin.model.Task
import com.example.taskmanagerkotlin.model.User

class UserWithTask {
    @Embedded val user: User=User()

    @Relation(parentColumn = TaskManagerSchema.User.UserColumns.ID,
        entityColumn = TaskManagerSchema.Task.TaskColumns.ID)
    var taskList:List<Task>?= listOf()
}