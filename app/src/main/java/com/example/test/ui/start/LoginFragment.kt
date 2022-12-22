package com.example.test.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.test.R
import com.example.test.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.loginBtn.setOnClickListener { view ->

            val valid = emailPasswordValid(binding.emailTF.editText?.text.toString(), binding.passwordTF.editText?.text.toString())

            if (valid)
                Toast.makeText(context, "please fill your missing data", Toast.LENGTH_SHORT).show()
            else {
                val navToWelcome: NavDirections =
                    LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
                view.findNavController().navigate(navToWelcome)
            }
        }
        
        binding.EnterBtn.setOnClickListener { view ->
            val navToWelcome: NavDirections =
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            view.findNavController().navigate(navToWelcome)
        }

        return binding.root
    }

    private fun emailPasswordValid(email: String, password: String): Boolean {
        return email.isEmpty() || password.isEmpty()
    }

}