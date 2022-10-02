package com.example.payzer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class home : Fragment() {

    private lateinit var budget: TextInputEditText
    private lateinit var save : TextInputEditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        val budget = view.findViewById<TextInputEditText>(R.id.budget_edittext)
        val save = view.findViewById<TextInputEditText>(R.id.save_edittext)
        val start = view.findViewById<MaterialButton>(R.id.get_start)


        start.setOnClickListener{
             if(budget.text?.isNotEmpty() == true && save.text?.isNotEmpty() == true){
                 val input = budget.text.toString()
                 val bundle = bundleOf("data" to input)
                findNavController().navigate(R.id.action_home2_to_main, bundle)
            }
            else{
                Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }


}