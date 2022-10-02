package com.example.payzer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*


class main : Fragment() {

//    private lateinit var adapter : MyAdapter
//    private lateinit var transactions : List<Transaction>
//    private lateinit var db : FirebaseDatabase
//    private lateinit var root : DatabaseReference
//    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val view: View = inflater.inflate(R.layout.fragment_main, container,false)
        val budget = view.findViewById<TextView>(R.id.budget_text_value)
        budget.text = arguments?.getString("data")
        val addBtn = view.findViewById<FloatingActionButton>(R.id.add_transaction_btn)

//        db =FirebaseDatabase.getInstance()
//        root = db.reference.child("label")
//
//        recyclerView = view.findViewById(R.id.transaction_list)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        recyclerView.setHasFixedSize(true)
//        adapter= MyAdapter(transactions)
//        recyclerView.adapter=adapter


//        root.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//
//                val value = snapshot.getValue(String::class.java)
//
//                // after getting the value we are setting
//                // our value to our text view in below line.
//                transactions.
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // calling on cancelled method when we receive
//                // any error or we are not able to get the data.
//                Toast.makeText(context, "Fail to get data.", Toast.LENGTH_SHORT).show()
//            }
//        })

        addBtn.setOnClickListener{
            findNavController().navigate(R.id.action_main_to_add_Transction_Fragment)
        }
        return view
    }
}
