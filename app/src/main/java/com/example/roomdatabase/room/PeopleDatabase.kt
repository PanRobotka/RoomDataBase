package com.example.roomdatabase.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1,  )

abstract class PeopleDatabase : RoomDatabase(){

    abstract fun peopleDao(): PeopleDao

    companion object{

        private var instance: PeopleDatabase? = null

        fun getInstance(context: Context):PeopleDatabase?{

            if (instance == null){

                instance = Room.databaseBuilder(
                    context,
                    PeopleDatabase::class.java,
                    "people_table")
                    .fallbackToDestructiveMigration()
                    .build()

            }
            return instance
        }
        fun deleteInstanceOFDatabase (){
        instance = null

        }
    }

}

