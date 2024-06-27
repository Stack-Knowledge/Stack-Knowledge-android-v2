package com.stackknowledge.di

import com.stackknowledge.repository.item.ItemRepository
import com.stackknowledge.repository.item.ItemRepositoryImpl
import com.stackknowledge.repository.mission.MissionRepository
import com.stackknowledge.repository.mission.MissionRepositoryImpl
import com.stackknowledge.repository.order.OrderRepository
import com.stackknowledge.repository.order.OrderRepositoryImpl
import com.stackknowledge.repository.student.StudentRepository
import com.stackknowledge.repository.student.StudentRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindMissionRepository(
        missionRepositoryImpl: MissionRepositoryImpl
    ): MissionRepository

    @Binds
    abstract fun bindStudentRepository(
        studentRepositoryImpl: StudentRepositoryImpl
    ): StudentRepository

    @Binds
    abstract fun bindOrderRepository(
        orderRepositoryImpl: OrderRepositoryImpl
    ): OrderRepository

    @Binds
    abstract fun bindItemRepository(
        itemRepositoryImpl: ItemRepositoryImpl
    ): ItemRepository
}