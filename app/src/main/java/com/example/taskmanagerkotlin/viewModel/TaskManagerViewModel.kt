package com.example.taskmanagerkotlin.viewModel

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import com.example.taskmanagerkotlin.view.fragment.TaskDialogFragment
import com.example.taskmanagerkotlin.view.fragment.TaskManagerFragment

const val REQUEST_CODE_ADD_TASK = 1


class TaskManagerViewModel(application: Application) : AndroidViewModel(application) {

    fun onClickAddTaskFAB(fragment: Fragment) {
        val taskDialogFragment: TaskDialogFragment = TaskDialogFragment.newInstance("add")

        taskDialogFragment.setTargetFragment(fragment, REQUEST_CODE_ADD_TASK)

        taskDialogFragment.show(fragment.parentFragmentManager,
            TaskManagerFragment.TASK_MANAGER_TAG)
    }
}