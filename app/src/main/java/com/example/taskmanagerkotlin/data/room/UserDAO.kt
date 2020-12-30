package com.example.taskmanagerkotlin.data.room

import androidx.room.*
import com.example.taskmanagerkotlin.model.User
@Dao
interface UserDAO {
    @Query(value = "SELECT * FROM userTable WHERE id=:id")
    fun get(id: Long): User

    @Query(value = "SELECT * FROM userTable")
    fun getList(): List<User>

    @Insert
    fun insert(t: User)

    @Delete
    fun delete(t: User)

    @Update
    fun update(t: User)
}