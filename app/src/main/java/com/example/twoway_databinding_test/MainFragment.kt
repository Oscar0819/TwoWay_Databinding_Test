package com.example.twoway_databinding_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.example.twoway_databinding_test.databinding.FragmentMainBinding


class MainFragment: Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        setUpView()
        setUpObserver()

        return binding.root
    }

    private fun setUpView() {
        binding.viewModel = ViewModel(R.drawable.ic_launcher_background, MutableLiveData(""), MutableLiveData(true))

    }

    private fun setUpObserver() {
        binding.viewModel?.content?.observe(viewLifecycleOwner) {
            binding.invalidateAll()
        }

        binding.viewModel?.showImage?.observe(viewLifecycleOwner) {
            binding.invalidateAll()
        }
    }
}