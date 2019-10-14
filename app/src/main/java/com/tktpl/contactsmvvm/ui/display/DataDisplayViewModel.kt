package com.tktpl.contactsmvvm.ui.display

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tktpl.contactsmvvm.data.db.ContactsEntry
import com.tktpl.contactsmvvm.data.repository.ContactRepositoryImpl
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DataDisplayViewModel(
    private val contactRepositoryImpl: ContactRepositoryImpl
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val dataDisplayer = MutableLiveData<List<ContactsEntry>>()

    fun bindUI() = launch {
        dataDisplayer.postValue(contactRepositoryImpl.dataDisplayer().value)
    }
}
