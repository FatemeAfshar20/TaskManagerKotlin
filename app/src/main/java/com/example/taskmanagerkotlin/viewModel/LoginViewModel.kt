package com.example.taskmanagerkotlin.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.taskmanagerkotlin.R
import com.example.taskmanagerkotlin.model.User
import com.example.taskmanagerkotlin.utils.ProgramUtils
import com.example.taskmanagerkotlin.utils.TskViewUtils

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val common =CommonLogicInSignAndLogin(application)

    fun onLoginBtnClickListener(){
        val user:User=common.user
        if (!user.userName?.let { common.repository?.checkUserExist(it) }!!){
            val userInput: User? =common.repository?.get(user.userName!!)
            if (userInput?.password.equals(user.password)) {
                common.iOnclickListener?.onButtonClickListener()

            }
            else
                TskViewUtils.returnToast(getApplication(), R.string.invalid_input)
        }else
            TskViewUtils.returnToast(getApplication(),"At first sign up")
    }
}