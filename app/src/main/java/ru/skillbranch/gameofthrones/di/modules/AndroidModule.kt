package ru.skillbranch.gameofthrones.di.modules

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import ru.skillbranch.gameofthrones.App2
import javax.inject.Singleton

@Module
class AndroidModule(private val application: App2) {

    @Provides
    @Singleton
    fun provideContext(): Context = application.applicationContext
}