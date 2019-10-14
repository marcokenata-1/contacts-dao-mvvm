package com.tktpl.contactsmvvm.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    val dataDisplayer = MutableLiveData<List<ContactsEntry>>()

    override suspend fun dataDisplayer(): MutableLiveData<List<ContactsEntry>> {
        return withContext(Dispatchers.IO){
            dataDisplayer.postValue(contactsDao.getContacts())
            return@withContext dataDisplayer
        }
    }
}