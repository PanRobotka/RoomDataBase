package com.example.roomdatabase.viewmodels
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.app.Application
import androidx.room.*
import kotlinx.coroutines.*
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import androidx.lifecycle.AndroidViewModel
import com.example.roomdatabase.room.Person
import com.example.roomdatabase.room.PeopleRepositor


//Nie działa



class PeopleViewMod (application: Application):
    AndroidViewModel(application) {

         private var peopleRepositor: PeopleRepositor =
             PeopleRepositor(application)
        private var allPeople: Deferred<LiveData<List<Person>>> =
            peopleRepositor.getAllPeopleAsync()

    fun insertPerson(person: Person){

        peopleRepositor.insertPerson(person)
    }
    fun updatePerson(person: Person) {

      peopleRepositor.updatePerson(person)

    }

    fun deletePerson(person: Person) {

        peopleRepositor.deletePerson(person)
    }

    fun getAllPeople(): LiveData<List<Person>> = runBlocking {
        allPeople.await()
    }

    fun deleteAllRows(){
        peopleRepositor.deleteAllRows()
    }

    }

