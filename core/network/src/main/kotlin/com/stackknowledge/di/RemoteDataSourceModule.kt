package com.stackknowledge.di

import com.stackknowledge.datasource.auth.AuthDataSource
import com.stackknowledge.datasource.auth.AuthDataSourceImpl
import com.stackknowledge.datasource.mission.MissionDataSource
import com.stackknowledge.datasource.mission.MissionDataSourceImpl
import com.stackknowledge.datasource.student.StudentDataSource
import com.stackknowledge.datasource.student.StudentDataSourceImpl
import com.stackknowledge.datasource.user.UserDataSource
import com.stackknowledge.datasource.user.UserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindAuthDataSource(
        authDataSourceImpl: AuthDataSourceImpl
    ): AuthDataSource

    @Binds
    @Singleton
    abstract fun bindMissionDataSource(
        missionDataSourceImpl: MissionDataSourceImpl
    ): MissionDataSource

    @Binds
    @Singleton
    abstract fun bindStudentDataSource(
        studentDataSourceImpl: StudentDataSourceImpl
    ): StudentDataSource

    @Binds
    @Singleton
    abstract fun bindUserDataSource(
        userDataSourceImpl: UserDataSourceImpl
    ): UserDataSource
}