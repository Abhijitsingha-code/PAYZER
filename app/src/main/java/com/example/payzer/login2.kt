package com.example.payzer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class login2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login2, container, false)
        val next2 = view.findViewById<Button>(R.id.next2_btn)
        next2.setOnClickListener{
            findNavController().navigate(R.id.action_login2_to_login3)
        }
        return view
    }

}