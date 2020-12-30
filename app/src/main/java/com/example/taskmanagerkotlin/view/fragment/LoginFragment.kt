package com.example.taskmanagerkotlin.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanagerkotlin.R
import com.example.taskmanagerkotlin.databinding.FragmentLoginBinding
import com.example.taskmanagerkotlin.view.IOnClickListener
import com.example.taskmanagerkotlin.viewModel.LoginViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() , IOnClickListener {
    var callback:LoginFragmentCallback?=null
    var viewModel:LoginViewModel?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is LoginFragmentCallback)
            callback= context  // why  don't need casting here?
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= activity?.application?.let { LoginViewModel(it) }
        viewModel!!.iOnclickListener=this
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentLoginBinding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_login,
            container,
            false)
        binding.viewModel=viewModel
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

     interface LoginFragmentCallback{
        fun onSignUpClickListener();
    }

    override fun onButtonClickListener() {
        callback?.onSignUpClickListener()
    }
}