package com.example.test.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.test.R
import com.example.test.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        binding.nexBtn.setOnClickListener { view ->
            val navToInstruction: NavDirections = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
            view.findNavController().navigate(navToInstruction)
        }

        return binding.root
    }

}