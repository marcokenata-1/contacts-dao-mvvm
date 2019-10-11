package com.tktpl.contactsmvvm.di

import com.tktpl.contactsmvvm.ui.display.DataDisplay
import com.tktpl.contactsmvvm.ui.insert.DataInsert
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule() {
    @ContributesAndroidInjector
    internal abstract fun DataDisplay() : DataDisplay

    @ContributesAndroidInjector
    internal abstract fun DataInsert() : DataInsert
}