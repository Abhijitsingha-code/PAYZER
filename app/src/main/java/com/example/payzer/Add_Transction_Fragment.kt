package com.example.payzer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase


class Add_Transction_Fragment : Fragment() {

    private val db = FirebaseDatabase.getInstance()
    private val root = db.getReference("label")



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View= inflater.inflate(R.layout.fragment_add__transction_, container, false)

        val addBtn = view.findViewById<Button>(R.id.add_button)
        val label = view.findViewById<TextInputEditText>(R.id.label_edittext)
        val Amount = view.findViewById<TextInputEditText>(R.id.amount_edittext)
        val desc = view.findViewById<TextInputEditText>(R.id.description_edittext)


        val labelInput =label.text.toString()
//        val amountInput =Amount.text.toString().toDoubleOrNull()
//        val desInput =desc.text.toString()


        addBtn.setOnClickListener{

            if(label.text?.isEmpty()==true){
                Toast.makeText(context,"Please Enter a Valid Label", Toast.LENGTH_SHORT).show()
            }
            if(Amount.text?.isEmpty()==null){
                Toast.makeText(context,"Please Enter the Amount", Toast.LENGTH_SHORT).show()
            }
            if(desc.text?.isEmpty()==true){
                Toast.makeText(context,"Please a description of the transaction", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context,"Successfully Added",Toast.LENGTH_SHORT).show()

//                val input = Transaction(Amount)

                root.child(labelInput).setValue(Amount).addOnCompleteListener {
                    label.text?.clear()
                    Amount.text?.clear()
                    desc.text?.clear()
                }
            }
        }
        return view
    }


}