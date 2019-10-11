package com.tktpl.contactsmvvm.di

import android.app.Application
import com.tktpl.contactsmvvm.MyApplication
import com.tktpl.contactsmvvm.data.repository.ContactRepositoryImpl
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,ViewModelModule::class,FragmentModule::class,ActivityModule::class,ContactRepositoryImpl::class,RoomModule::class))
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun contactImplementation(contactRepositoryImpl: ContactRepositoryImpl)

        fun build(): AppComponent
    }

}