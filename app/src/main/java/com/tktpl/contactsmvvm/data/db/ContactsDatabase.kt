package com.tktpl.contactsmvvm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ContactsEntry::class],
    version = 2,
    exportSchema = false
)
abstract class ContactsDatabase : RoomDatabase(){
    abstract fun contactsDao() : ContactsDao

//        @Volatile private var instance : ContactsDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
//            instance ?: buildDatabase(context).also { instance = it }
//        }
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
//            ContactsDatabase::class.java,"contacts.db")
//            .build()


}