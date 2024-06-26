package com.stackknowledge.di

import com.stackknowledge.api.MissionAPI
import com.stackknowledge.api.StudentAPI
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

    @Provides
    fun provideStudentAPI(retrofit: Retrofit): StudentAPI =
        retrofit.create(StudentAPI::class.java)
}