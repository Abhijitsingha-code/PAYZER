package com.example.payzer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.payzer.databinding.FragmentLogin3Binding
import com.example.payzer.databinding.FragmentLoginBinding

class login3 : Fragment() {

    private var _binding: FragmentLogin3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentLogin3Binding.inflate(inflater, container, false)

        binding.loginBtn.setOnClickListener{
            findNavController().navigate(R.id.action_login3_to_login4)
        }

        binding.signupBtn.setOnClickListener{
            findNavController().navigate(R.id.action_login3_to_signin)
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}