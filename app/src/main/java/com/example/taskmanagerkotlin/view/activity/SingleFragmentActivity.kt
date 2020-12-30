package com.example.taskmanagerkotlin.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.taskmanagerkotlin.R

abstract class SingleFragmentActivity : AppCompatActivity() {

    abstract fun createFragment():Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment:Fragment?=
            supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment==null)
            supportFragmentManager.
            beginTransaction().
            add(R.id.fragment_container,createFragment()).
            commit()
    }

}