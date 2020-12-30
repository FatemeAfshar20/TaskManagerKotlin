package com.example.taskmanagerkotlin.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.taskmanagerkotlin.R
import com.example.taskmanagerkotlin.databinding.FragmentSignBinding
import com.example.taskmanagerkotlin.view.IOnClickListener
import com.example.taskmanagerkotlin.viewModel.SignUpViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() , IOnClickListener{
    var callback:SignUpFragmentCallback?=null
    var viewModel:SignUpViewModel?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SignUpFragmentCallback)
            callback= context  // why  don't need casting here?
        else
            throw ClassCastException("At first must implement LoginFragmentCallback interface")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= activity?.application?.let { SignUpViewModel(it) }
        viewModel?.common?.iOnclickListener =this

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentSignBinding=DataBindingUtil
            .inflate(inflater,
                R.layout.fragment_sign,
                container,
                false)
        binding.viewModel=viewModel
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment SingUpFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            SignUpFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onButtonClickListener() {
            callback?.onSignClickListener()
    }

    interface SignUpFragmentCallback{
        fun onSignClickListener()
    }
}