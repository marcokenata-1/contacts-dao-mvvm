package com.tktpl.contactsmvvm.ui.insert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tktpl.contactsmvvm.data.repository.ContactRepositoryImpl
import dagger.Module
import javax.inject.Inject

@Module
class DataInsertViewModelFactory @Inject constructor(
    private val contactRepositoryImpl: ContactRepositoryImpl
):ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DataInsertViewModel(contactRepositoryImpl) as T
    }
}