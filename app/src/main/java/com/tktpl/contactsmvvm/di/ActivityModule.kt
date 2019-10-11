package com.tktpl.contactsmvvm.di

import com.tktpl.contactsmvvm.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivityInjector() : MainActivity
}