package com.example.taskmanagerkotlin.data

import android.content.Context
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.taskmanagerkotlin.data.room.TaskManagerDatabase
import com.example.taskmanagerkotlin.data.room.UserDAO
import com.example.taskmanagerkotlin.model.User
import javax.security.auth.callback.Callback

class UserRepository private constructor(context: Context) :
    IRepository<User> {
    private val mContext: Context = context.applicationContext
    private val mDAO: UserDAO

    override fun get(id: Long): User {
        return mDAO.get(id)
    }

    fun get(username: String): User? {
        return mDAO.get(username)
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
        val database = Room.databaseBuilder(mContext, TaskManagerDatabase::class.java,
            "note_database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

        mDAO = database.getUserDAo()
    }

    fun checkUserExist(username:String) : Boolean{
        return get(username) == null
    }
}