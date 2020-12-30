package com.example.taskmanagerkotlin.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.taskmanagerkotlin.data.TaskRepository
import com.example.taskmanagerkotlin.model.Task

class DialogViewModel(application: Application) : AndroidViewModel(application) {
    val repository: TaskRepository? = TaskRepository.getInstance(application)
    var task: Task? = null

    fun onTextChangedTaskTitle(taskTitle: CharSequence, i: Int, j: Int, k: Int) {
        task?.title = taskTitle.toString()
    }

    fun onTextChangedTaskDescription(description: CharSequence, i: Int, j: Int, k: Int) {
        task?.description = description.toString()
    }

    fun onSaveBtnClickListener(){
        task?.let { repository?.insert(it) }
    }

    fun setUserId(userId: Int){
        task?.userId=userId
    }

}