package com.example.taskmanagerkotlin.viewModel

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import com.example.taskmanagerkotlin.view.fragment.TaskDialogFragment

const val REQUEST_CODE_ADD_TASK = 1
const val DIALOG_FRAGMENT_TAG = "Task Dialog Fragment"

class TaskManagerViewModel(application: Application) : AndroidViewModel(application) {

    fun onClickAddTaskFAB(fragment: Fragment) {
        val taskDialogFragment: TaskDialogFragment = TaskDialogFragment.newInstance("add")

        taskDialogFragment.setTargetFragment(fragment, REQUEST_CODE_ADD_TASK)

        taskDialogFragment.show(fragment.childFragmentManager, DIALOG_FRAGMENT_TAG)
    }
}