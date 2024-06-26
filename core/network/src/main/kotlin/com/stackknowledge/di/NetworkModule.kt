package com.stackknowledge.di

import com.stackknowledge.api.MissionAPI
import com.stackknowledge.datasource.mission.MissionDataSource
import com.stackknowledge.datasource.mission.MissionDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideMissionAPI(retrofit: Retrofit): MissionAPI =
        retrofit.create(MissionAPI::class.java)
}