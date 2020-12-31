package com.example.taskmanagerkotlin.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanagerkotlin.R
import com.example.taskmanagerkotlin.databinding.FragmentDialogBinding
import com.example.taskmanagerkotlin.viewModel.DialogViewModel
import com.example.taskmanagerkotlin.viewModel.SignUpViewModel
import com.example.taskmanagerkotlin.viewModel.TaskManagerViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [TaskDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val ARG_WORK="Work"
class TaskDialogFragment : DialogFragment() {
    var viewModel:DialogViewModel?=null
    var work:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= activity?.application?.let { DialogViewModel(it) }

        arguments?.let {
            work= arguments!!.getString(ARG_WORK).toString()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentDialogBinding=DataBindingUtil.
        inflate(inflater,
            R.layout.fragment_dialog,
            container,
            false)
        binding.viewModel=viewModel
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(work:String) =
            TaskDialogFragment().apply {
                arguments = Bundle().apply {
                    arguments?.putString(ARG_WORK,work)
                }
            }
    }
}