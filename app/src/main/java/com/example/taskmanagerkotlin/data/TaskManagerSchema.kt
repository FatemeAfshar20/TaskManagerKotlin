package com.example.taskmanagerkotlin.data

object TaskManagerSchema {
    const val NAME = "task_manager.db"
    const val VERSION = 1

    object User {
        const val NAME = "userTable"

        object UserColumns {
            const val ID = "id"
            const val UUID = "uuid"
            const val USERNAME = "username"
            const val PASSWORD = "password"
            const val MEMBERSHIP = "membership"
            const val IS_ADMIN = "isAdmin"
        }
    }

    object Task {
        const val NAME = "taskTable"

        object TaskColumns {
            const val ID = "id"
            const val TITLE = "title"
            const val CONTENT = "content"
            const val DATE = "date"
            const val TIME = "time"
            const val STATE = "state"
            const val USER_ID = "userId"
            const val IMAGE_ADDRESS = "imageAddress"
        }
    }
}