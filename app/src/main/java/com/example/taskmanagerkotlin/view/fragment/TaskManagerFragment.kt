package com.example.taskmanagerkotlin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.taskmanagerkotlin.R
import com.example.taskmanagerkotlin.databinding.FragmentTaskManagerBinding
import com.example.taskmanagerkotlin.viewModel.TaskManagerViewModel

class TaskManagerFragment : Fragment() {
    var viewModel: TaskManagerViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.application?.let { TaskManagerViewModel(it) }

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTaskManagerBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_task_manager,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.fragment = this
        return binding.root
    }

    companion object {
        const val TASK_MANAGER_TAG = "Task Dialog Fragment"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TaskManagerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            TaskManagerFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}