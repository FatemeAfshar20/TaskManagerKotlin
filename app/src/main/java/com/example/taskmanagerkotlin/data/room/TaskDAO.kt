package com.example.taskmanagerkotlin.data.room

import androidx.room.*
import com.example.taskmanagerkotlin.model.Task

@Dao
interface TaskDAO {
    @Query(value = "SELECT * FROM taskTable WHERE id=:id")
    fun get(id: Long): Task

    @Query(value = "SELECT * FROM taskTable")
    fun getList(): List<Task>

    @Insert
    fun insert(t: Task)

    @Delete
    fun delete(t: Task)

    @Update
    fun update(t: Task)
}