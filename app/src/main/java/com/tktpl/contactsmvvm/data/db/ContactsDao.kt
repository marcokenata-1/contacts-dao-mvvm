package com.tktpl.contactsmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contactsEntry: ContactsEntry)

    @Query("select * from contacts_insertion")
    fun getContacts() : LiveData<ContactsEntry>
}