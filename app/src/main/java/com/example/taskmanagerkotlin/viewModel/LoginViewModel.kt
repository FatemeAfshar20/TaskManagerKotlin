package com.example.taskmanagerkotlin.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.taskmanagerkotlin.data.UserRepository
import com.example.taskmanagerkotlin.model.User
import com.example.taskmanagerkotlin.view.IOnClickListener

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private var repository:UserRepository?=null
    private var user:User?=null
    var iOnclickListener:IOnClickListener?=null

    init {
        repository= UserRepository.getInstance(application)
    }

    fun onTextChangedUserName(username:CharSequence,i:Int,j:Int,k:Int){
        user?.userName =username.toString()
    }

    fun onTextChangePassword(password:CharSequence,i:Int,j:Int,k:Int){
        user?.password =password.toString()
    }

    fun onTextChangeAdminPass(adminPass:CharSequence,i:Int,j:Int,k:Int){
        if (adminPass.toString()=="@utab")
            user?.isAdmin=true
    }

    fun onSignBtnClickListener(){
        iOnclickListener?.onButtonClickListener()
    }
}