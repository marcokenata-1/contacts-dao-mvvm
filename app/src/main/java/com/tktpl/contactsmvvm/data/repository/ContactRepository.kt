package com.tktpl.contactsmvvm.data.repository

import androidx.lifecycle.LiveData
import com.tktpl.contactsmvvm.data.db.ContactsEntry

interface ContactRepository {
    suspend fun dataInsertion(contactsEntry: ContactsEntry)

    suspend fun dataDisplayer() : List<ContactsEntry>
}