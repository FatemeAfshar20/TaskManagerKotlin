package com.example.taskmanagerkotlin.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.taskmanagerkotlin.R
import com.example.taskmanagerkotlin.model.User
import com.example.taskmanagerkotlin.utils.TskViewUtils

class SignUpViewModel(application: Application) : AndroidViewModel(application) {

    val common = CommonLogicInSignAndLogin(application)

    fun onTextChangeAdminPass(adminPass: CharSequence, i: Int, j: Int, k: Int) {
        if (adminPass.toString() == "@utab")
            common.user.isAdmin = true
    }

    fun onSignBtnClickListener() {
        val user: User = common.user
        if (user.userName?.let { common.repository?.checkUserExist(it) }!!) {
            if (user.password?.length!! >= 8) {
                common.repository?.insert(user)
                common.iOnclickListener?.onButtonClickListener()
            } else
                TskViewUtils.returnToast(getApplication(), R.string.length_pass)
        } else
            TskViewUtils.returnToast(getApplication(), R.string.user_exist)
    }

}