package com.tktpl.contactsmvvm.ui.insert

import androidx.lifecycle.ViewModel
import com.tktpl.contactsmvvm.data.db.ContactsEntry
import com.tktpl.contactsmvvm.data.repository.ContactRepositoryImpl
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DataInsertViewModel(
    private val contactRepositoryImpl: ContactRepositoryImpl
) : ViewModel(), CoroutineScope {


    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    fun bindUI(name: String, number: Int, relation: String) = launch {
        contactRepositoryImpl.dataInsertion(ContactsEntry(name, number, relation))
    }


}
