package com.example.roomdatabase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.room.Person
import kotlinx.android.synthetic.main.person_row.*
import kotlinx.android.synthetic.main.person_row.view.*

class DaoAdapter(private val listOfPeople: List<Person>): RecyclerView.Adapter<DaoAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.person_row,parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imieTextView.text = listOfPeople[position].imie
        holder.nazwiskoTextView.text = listOfPeople[position].nazwisko
        holder.peselTextView.text = listOfPeople[position].pesel

    }

    override fun getItemCount(): Int {
        return listOfPeople.size
    }

class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
    val imieTextView: TextView = view.findViewById(R.id.row_imie)
    val nazwiskoTextView: TextView = view.findViewById(R.id.row_nazwisko)
    val peselTextView: TextView = view.findViewById(R.id.row_pesel)

}
}