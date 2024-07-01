package com.stackknowledge.di

import com.stackknowledge.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppConfigModule {
    @Provides
    @Named("GOOGLE_CLIENT_ID")
    fun provideGoogleClientId(): String = BuildConfig.GOOGLE_CLIENT_ID

    @Provides
    @Named("SCOPE")
    fun provideScope(): String = BuildConfig.SCOPE
}