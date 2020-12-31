package com.example.taskmanagerkotlin.utils

import android.app.Application
import android.content.Context
import android.widget.Toast

class TskViewUtils {
    companion object {
        fun returnToast(application: Application, msg: String) =
            Toast.makeText(application, msg, Toast.LENGTH_LONG).show()

        fun returnToast(application: Application, msg: Int) =
            Toast.makeText(application, msg, Toast.LENGTH_LONG).show()
    }
}