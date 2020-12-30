package com.example.taskmanagerkotlin.viewModel

import android.content.Context
import com.example.taskmanagerkotlin.data.UserRepository
import com.example.taskmanagerkotlin.model.User
import com.example.taskmanagerkotlin.view.IOnClickListener

 class CommonLogicInSignAndLogin(context: Context) {
    var repository: UserRepository? = null
    var iOnclickListener: IOnClickListener? = null
     var user= User()

    init {
        repository = UserRepository.getInstance(context.applicationContext)
    }

     fun onTextChangedUserName(username:CharSequence,i:Int,j:Int,k:Int){
         user.userName=username.toString()
     }
     fun onTextChangePassword(password: CharSequence, i: Int, j: Int, k: Int){
         user.password=password.toString()
     }
}