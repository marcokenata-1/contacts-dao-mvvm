package com.tktpl.contactsmvvm.data.repository

import androidx.lifecycle.LiveData
import com.tktpl.contactsmvvm.data.db.ContactsDao
import com.tktpl.contactsmvvm.data.db.ContactsEntry
import dagger.Module
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Module
class ContactRepositoryImpl @Inject constructor(
    private val contactsDao: ContactsDao
) : ContactRepository {
    override suspend fun dataInsertion(contactsEntry: ContactsEntry) {
        withContext(Dispatchers.IO){
            contactsDao.insertContact(contactsEntry)
        }
    }

    override suspend fun dataDisplayer(): List<ContactsEntry> {
        return withContext(Dispatchers.IO){
            return@withContext contactsDao.getContacts()
        }
    }
}