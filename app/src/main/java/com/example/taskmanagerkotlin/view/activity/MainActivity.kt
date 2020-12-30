package com.example.taskmanagerkotlin.view.activity

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.taskmanagerkotlin.R
import com.example.taskmanagerkotlin.view.fragment.LoginFragment
import com.example.taskmanagerkotlin.view.fragment.SignUpFragment

private const val LOGIN_FRAGMENT_TAG: String = "Login fragment"

class MainActivity : SingleFragmentActivity(), LoginFragment.LoginFragmentCallback {
    fun newIntent(context: Context): Intent {
        return Intent(context, this::class.java)
    }

    override fun createFragment(): Fragment {
        supportFragmentManager.beginTransaction()
            .add(LoginFragment.newInstance(), LOGIN_FRAGMENT_TAG)
        return LoginFragment.newInstance()
    }

    override fun onSignUpClickListener() {
        supportFragmentManager.beginTransaction().
        replace(R.id.fragment_container,SignUpFragment.newInstance()).
        addToBackStack(LOGIN_FRAGMENT_TAG).commit()
    }
}