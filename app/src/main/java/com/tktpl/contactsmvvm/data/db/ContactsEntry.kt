package com.tktpl.contactsmvvm.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_insertion")
data class ContactsEntry (
    val name: String,
    val number: Int,
    val relation: String
){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}