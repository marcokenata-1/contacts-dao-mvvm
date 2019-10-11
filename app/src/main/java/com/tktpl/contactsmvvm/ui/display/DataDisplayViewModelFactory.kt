package com.tktpl.contactsmvvm.ui.display

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tktpl.contactsmvvm.data.repository.ContactRepositoryImpl
import dagger.Module
import javax.inject.Inject

@Module
class DataDisplayViewModelFactory @Inject constructor(
    private val contactRepositoryImpl: ContactRepositoryImpl
):ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DataDisplayViewModel(contactRepositoryImpl) as T
    }
}