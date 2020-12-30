package com.example.taskmanagerkotlin.data

import android.content.Context
import androidx.room.Room
import com.example.taskmanagerkotlin.data.room.TaskDAO
import com.example.taskmanagerkotlin.data.room.TaskManagerDatabase
import com.example.taskmanagerkotlin.model.Task

class TaskRepository private constructor(context: Context) : IRepository<Task>{
    private val mContext: Context = context.applicationContext
    private val mDAO: TaskDAO

    companion object {
        private var sInstance: TaskRepository? = null
        fun getInstance(context: Context): TaskRepository? {
            if (sInstance == null) sInstance =
                TaskRepository(context)
            return sInstance
        }
    }

    init {
        val database = Room.databaseBuilder(mContext, TaskManagerDatabase::class.java,
            "note_database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

        mDAO = database.getTaskDao()
    }

    override fun get(id: Long): Task {
       return mDAO.get(id)
    }

    override fun getList(): List<Task> {
        return mDAO.getList()
    }

    override fun insert(t: Task) {
        mDAO.insert(t)
    }

    override fun delete(t: Task) {
        mDAO.delete(t)
    }

    override fun update(t: Task) {
        mDAO.update(t)
    }
}