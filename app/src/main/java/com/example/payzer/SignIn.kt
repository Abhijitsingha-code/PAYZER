package com.example.payzer


import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.payzer.databinding.FragmentSigninBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignIn : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var email : TextInputEditText
    private lateinit var password : TextInputEditText
    private lateinit var confirmpassword : TextInputEditText
    private lateinit var start : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ?{

        val firebaseAuth = FirebaseAuth.getInstance()
        val view : View= inflater.inflate(R.layout.fragment_signin, container,false)
        val email = view.findViewById<TextInputEditText>(R.id.email_text)
        val password  = view.findViewById<TextInputEditText>(R.id.password_edit_view)
        val confirmPassword  = view.findViewById<TextInputEditText>(R.id.confPassword_edit_view)
        val start  = view.findViewById<Button>(R.id.get_started_btn)

           start.setOnClickListener{
            if(email.text?.isEmpty()==true || password.text?.isEmpty()==true || confirmPassword.text?.isEmpty()==true){
                Toast.makeText(context,"Empty Fill Not Allow!!", Toast.LENGTH_SHORT).show()
            }
            else{
                if( password.text.toString() == confirmPassword.text.toString() ) {
                    firebaseAuth.createUserWithEmailAndPassword(
                        email.text.toString().trim(),
                        password.text.toString().trim()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
//                            sendEmailVerification()
                            findNavController().navigate(R.id.action_signin_to_home2)
                        }
                    }
                }
               else{
                    Toast.makeText(context,"Password and Confirm Password does not match.", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }

    private   fun sendEmailVerification() {
        val firebaseUser: FirebaseUser? = firebaseAuth.currentUser
        firebaseUser?.let {
            it.sendEmailVerification().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context,"Email has sent to your email address please verify before login", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    override fun onDestroyView() = super.onDestroyView()
}



