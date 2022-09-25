package com.example.payzer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.payzer.databinding.FragmentLogin3Binding
import com.example.payzer.databinding.FragmentSigninBinding

class signin : Fragment() {

    private var _binding: FragmentSigninBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentSigninBinding.inflate(inflater, container, false)

        binding.getStartedBtn.setOnClickListener{
            findNavController().navigate(R.id.action_signin_to_home2)
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}