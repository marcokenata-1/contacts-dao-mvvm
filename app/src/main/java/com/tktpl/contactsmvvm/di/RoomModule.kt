package com.tktpl.contactsmvvm.di

import android.app.Application
import androidx.room.Room
import com.tktpl.contactsmvvm.data.db.ContactsDao
import com.tktpl.contactsmvvm.data.db.ContactsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {


    @Provides
    @Singleton
    fun provideDatabase(application: Application): ContactsDatabase {
        return Room.databaseBuilder(
            application,
            ContactsDatabase::class.java, "contacts.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }


    /*
     * We need the MovieDao module.
     * For this, We need the AppDatabase object
     * So we will define the providers for this here in this module.
     * */

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: ContactsDatabase): ContactsDao {
        return appDatabase.contactsDao()
    }
}