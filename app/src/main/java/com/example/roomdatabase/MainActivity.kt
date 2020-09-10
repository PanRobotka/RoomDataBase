package com.example.roomdatabase
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.room.Person
import com.example.roomdatabase.R
import kotlinx.android.synthetic.main.activity_main.*
import com.example.roomdatabase.viewmodels.PeopleViewMod

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PeopleViewMod
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(PeopleViewMod::class.java)

        insertBT.setOnClickListener {
            val imie = imieET.text.toString()
            val nazwisko = nazwiskoET.text.toString()
            val pesel = peselET.text.toString()

            val person = Person(imie, nazwisko, pesel)

            viewModel.insertPerson(person)
        }
        showListBT.setOnClickListener {
            val intent = Intent(applicationContext, activity_show::class.java)
            startActivity(intent)
        }
        clearDataBT.setOnClickListener {
            viewModel.deleteAllRows()
        }

    }
}