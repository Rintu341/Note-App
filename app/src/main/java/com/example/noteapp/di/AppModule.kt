package com.example.noteapp.di

import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.NoteDatabase
import com.example.noteapp.data.NoteDatabaseDao
import com.example.noteapp.model.Note
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase):NoteDatabaseDao
    = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):NoteDatabase
    = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        name = "note_table"
    ).fallbackToDestructiveMigration().build()
}