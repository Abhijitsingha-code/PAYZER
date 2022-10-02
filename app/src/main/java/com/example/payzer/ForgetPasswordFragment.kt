package com.example.payzer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var emailId : TextInputEditText
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        firebaseAuth = FirebaseAuth.getInstance()
        val view : View= inflater.inflate(R.layout.fragment_forget_password, container, false)
        emailId= view.findViewById<TextInputEditText>(R.id.email_editInputText)
        button=view.findViewById<Button>(R.id.send_button)

        button.setOnClickListener{
            if (emailId.text?.isEmpty()==true){
                Toast.makeText(context,"Please enter email address",Toast.LENGTH_SHORT).show()
            }else{
                firebaseAuth.sendPasswordResetEmail(emailId.text.toString().trim()).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context,"Email has send successfully to reset password.",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(context , it.exception!!.message.toString(),Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        return view
    }

}