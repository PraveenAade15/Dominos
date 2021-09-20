package com.praveene.dominosapp.di

import android.content.Context
import androidx.room.Room
import com.praveene.dominosapp.data.local.ResponseDatabase
import com.praveene.dominosapp.util.Constants.ROOM_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ResponseDatabase = Room.databaseBuilder(
        context,
        ResponseDatabase::class.java,
        ROOM_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: ResponseDatabase) = database.responseDao()
}