package com.gerald.listrecycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val usersList: List<Person>, val context: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //retrieve single person
        val user = usersList[position]
        holder.txtPhone.text = user.phone //displaying list items
        holder.txtName.text = user.name

        holder.itemView.setOnClickListener {//used to show what will be seen when clicked.
            Toast.makeText(holder.itemView.context, user.email, Toast.LENGTH_SHORT).show()
            val intent = Intent(
                holder.itemView.context,
                DetailsActivity::class.java
            )//object that opens another page
            intent.putExtra("name", user.name)
            intent.putExtra("email", user.email)
            intent.putExtra("phone", user.phone)
            intent.putExtra("address", user.address)
            intent.putExtra("age", user.age)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtPhone: TextView = itemView.findViewById(R.id.txtPhone)
    }

}