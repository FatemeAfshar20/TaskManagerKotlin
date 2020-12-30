package com.example.taskmanagerkotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskmanagerkotlin.data.TaskManagerSchema
import com.example.taskmanagerkotlin.data.TaskManagerSchema.User.UserColumns
import java.util.*

@Entity(tableName = TaskManagerSchema.User.NAME)
class User() {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = UserColumns.ID)
    var id: Long? = null

    @ColumnInfo(name = UserColumns.USERNAME)
    var userName: String? = null

    @ColumnInfo(name = UserColumns.PASSWORD)
    var password: String? = null

    @ColumnInfo(name = UserColumns.IS_ADMIN)
    var isAdmin: Boolean= false

    @ColumnInfo(name = UserColumns.MEMBERSHIP)
    var membership: Date = Date()

    fun User(
        id: Long,
        username: String,
        password: String,
        isAdmin: Boolean,
        membership: Date
    ) {
        this.id = id
        this.userName = username
        this.password = password
        this.isAdmin = isAdmin
        this.membership = membership
    }
}