package com.example.taskmanagerkotlin.view.activity

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.taskmanagerkotlin.R
import com.example.taskmanagerkotlin.view.fragment.LoginFragment
import com.example.taskmanagerkotlin.view.fragment.SignUpFragment
import com.example.taskmanagerkotlin.view.fragment.TaskManagerFragment

private const val LOGIN_FRAGMENT_TAG: String = "Login fragment"
private const val SIGN_FRAGMENT_TAG: String = "Sign fragment"

class MainActivity : SingleFragmentActivity(),
    LoginFragment.LoginFragmentCallback ,
    SignUpFragment.SignUpFragmentCallback{

    fun newIntent(context: Context): Intent {
        return Intent(context, this::class.java)
    }

    override fun createFragment(): Fragment {
        supportFragmentManager.beginTransaction()
            .add(LoginFragment.newInstance(), LOGIN_FRAGMENT_TAG)
        supportFragmentManager.beginTransaction()
            .add(SignUpFragment.newInstance(), SIGN_FRAGMENT_TAG)
        return LoginFragment.newInstance()
    }

    override fun onSignUpClickListener() {
        supportFragmentManager.beginTransaction().
        replace(R.id.fragment_container,SignUpFragment.newInstance()).
        addToBackStack(LOGIN_FRAGMENT_TAG).commit()
    }

    override fun onLoginClickListener() {
        supportFragmentManager.beginTransaction().
        replace(R.id.fragment_container,TaskManagerFragment.newInstance()).
        addToBackStack(LOGIN_FRAGMENT_TAG).commit()
    }

    override fun onSignClickListener() {
        supportFragmentManager.beginTransaction().
        replace(R.id.fragment_container,LoginFragment.newInstance())
            .commit()
    }
}