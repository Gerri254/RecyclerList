package com.gerald.listrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.bloco.faker.Faker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val faker = Faker()
        var peopleList = arrayListOf<Person>()

        for (i in 1..500) {
            val name = faker.name.firstName() + "" + faker.name.lastName()
            val email = faker.internet.email()
            val address = faker.address.streetAddress()
            val age = faker.number.between(18, 75)
            val university = faker.university.name()
            val phone = faker.phoneNumber.phoneNumber()
            // Log.d("FAKER", "$name : $email :$address : $age : $university")//debugging
            val person = Person(name, email, address, age, phone)
            peopleList.add(person)
        }
        // peopleList.forEach{Log.d("PEOPLE",it.name)}

        val RecyclerPeople: RecyclerView = findViewById(R.id.recyclerViewPeople)
        RecyclerPeople.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(peopleList, this)
        RecyclerPeople.adapter = adapter


    }
}