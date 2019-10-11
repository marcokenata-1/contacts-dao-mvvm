package com.tktpl.contactsmvvm.di

import androidx.lifecycle.ViewModel
import com.tktpl.contactsmvvm.ui.display.DataDisplayViewModel
import com.tktpl.contactsmvvm.ui.insert.DataInsertViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DataDisplayViewModel::class)
    abstract fun bindDataDisplayViewModel(viewModel : DataDisplayViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DataInsertViewModel::class)
    abstract fun bindTopRatedViewModel(viewModel: DataInsertViewModel) : ViewModel

}