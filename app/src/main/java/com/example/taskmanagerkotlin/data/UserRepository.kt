package com.example.taskmanagerkotlin.data

import android.content.Context
import androidx.room.Room
import com.example.taskmanagerkotlin.data.room.TaskManagerDatabase
import com.example.taskmanagerkotlin.data.room.UserDAO
import com.example.taskmanagerkotlin.model.User

class UserRepository private constructor(context: Context) :
    IRepository<User> {
    private val mContext: Context
    private val mDAO: UserDAO

    override fun get(id: Long): User {
        return mDAO.get(id)
    }

    override fun getList(): List<User> {
        return mDAO.getList()
    }

    override fun insert(user: User) {
        mDAO.insert(user)
    }

    override fun delete(user: User) {
        mDAO.delete(user)
    }

    override fun update(user: User) {
        mDAO.update(user)
    }

    companion object {
        private var sInstance: UserRepository? = null
        fun getInstance(context: Context): UserRepository? {
            if (sInstance == null) sInstance =
                UserRepository(context)
            return sInstance
        }
    }

    init {
        mContext = context.applicationContext
        val database = Room.databaseBuilder(
            mContext,
            TaskManagerDatabase::class.java,
            TaskManagerSchema.NAME).
        allowMainThreadQueries().build()
        mDAO = database.getUserDAo()
    }
}