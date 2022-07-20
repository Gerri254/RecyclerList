package com.gerald.listrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val txtEmail :TextView = findViewById(R.id.txtEmail)
        val txtAddress : TextView = findViewById(R.id.txtAddress)
        val txtAge : TextView = findViewById(R.id.txtAge)
        val txtPhone : TextView = findViewById(R.id.txtPhoneNumber)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val address = intent.getStringExtra("address")
        val phone = intent.getStringExtra("phone")
        val age = intent.getIntExtra("age",20)

        txtAddress.text =address
        txtAge.text = age.toString()
        txtPhone.text = phone
        txtEmail.text = email

        val actionBar = supportActionBar
        actionBar!!.title = name





    }
}