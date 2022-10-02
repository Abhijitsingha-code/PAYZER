package com.example.payzer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class login : Fragment() {


    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var email : TextInputEditText
    private lateinit var password : TextInputEditText
    private lateinit var conti: Button
    private lateinit var forgetPassword: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

         firebaseAuth = FirebaseAuth.getInstance()
        val view : View= inflater.inflate(R.layout.fragment_login, container,false)
         email = view.findViewById<TextInputEditText>(R.id.email_editview)
         password  = view.findViewById<TextInputEditText>(R.id.password_edittext)
         conti = view.findViewById<Button>(R.id.continue_btn)
        forgetPassword = view.findViewById<TextView>(R.id.forget_tv)

        forgetPassword.setOnClickListener{
            findNavController().navigate(R.id.action_login4_to_forgetPasswordFragment)
        }


        conti.setOnClickListener{
            if (email.text?.isEmpty()==true || password.text?.isEmpty()==true ) {
                Toast.makeText( requireActivity() , "Empty Fills Are Not Allow!!", Toast.LENGTH_SHORT).show()
            }else{
                firebaseAuth.signInWithEmailAndPassword(email.text.toString().trim() , password.text.toString().trim()).addOnCompleteListener{
                    if (it.isSuccessful) {
                        findNavController().navigate(R.id.action_login4_to_home2)
                    }
                }
            }
        }

        return view
    }

}