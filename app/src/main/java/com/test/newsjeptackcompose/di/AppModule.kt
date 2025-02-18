package com.test.newsjeptackcompose.di

import android.app.Application
import com.test.newsjeptackcompose.data.manager.LocalUserMangerImpl
import com.test.newsjeptackcompose.domain.manager.LocalUserManger
import com.test.newsjeptackcompose.domain.usecases.AppEntryUseCases
import com.test.newsjeptackcompose.domain.usecases.ReadAppEntry
import com.test.newsjeptackcompose.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
}