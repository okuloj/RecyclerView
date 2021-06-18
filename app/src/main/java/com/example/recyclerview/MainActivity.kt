package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter
    private var arrayList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)

        arrayList.add("Word 1")
        arrayList.add("Word 2")
        arrayList.add("Word 3")
        arrayList.add("Word 4")
        arrayList.add("Word 5")
        arrayList.add("Word 6")
        arrayList.add("Word 7")
        arrayList.add("Word 8")
        arrayList.add("Word 9")

        recyclerAdapter = RecyclerAdapter(arrayList as ArrayList<String>)
        recyclerView.adapter = recyclerAdapter

        var buttonAdd: ImageButton = findViewById(R.id.imageButton)
        buttonAdd.setOnClickListener {
            dialog()
        }

    }

    private fun dialog() {
        val builder = AlertDialog.Builder(this)
        val inflater2 = layoutInflater
        builder.setTitle("Nhap du lieu")
        val dialogLayout = inflater2.inflate(R.layout.custom_dialog, null)
        val editText  = dialogLayout.findViewById<EditText>(R.id.editTextDialog)
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") {
                dialogInterface, i ->
            run {
                arrayList.add("+ ${editText.text.toString()}")
                recyclerAdapter.notifyDataSetChanged()
            }
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }
}

