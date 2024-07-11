package com.stackknowledge.di

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.stackknowledge.api.AuthAPI
import com.stackknowledge.api.ItemAPI
import com.stackknowledge.api.MissionAPI
import com.stackknowledge.api.OrderAPI
import com.stackknowledge.api.SolveAPI
import com.stackknowledge.api.StudentAPI
import com.stackknowledge.api.UserAPI
import com.stackknowledge.network.BuildConfig
import com.stackknowledge.util.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message -> Log.v("HTTP", message) }
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkhttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthAPI(retrofit: Retrofit): AuthAPI =
        retrofit.create(AuthAPI::class.java)

    @Provides
    @Singleton
    fun provideMissionAPI(retrofit: Retrofit): MissionAPI =
        retrofit.create(MissionAPI::class.java)

    @Provides
    @Singleton
    fun provideStudentAPI(retrofit: Retrofit): StudentAPI =
        retrofit.create(StudentAPI::class.java)

    @Provides
    @Singleton
    fun providesOrderAPI(retrofit: Retrofit): OrderAPI =
        retrofit.create(OrderAPI::class.java)

    @Provides
    @Singleton
    fun providesItemAPI(retrofit: Retrofit): ItemAPI =
        retrofit.create(ItemAPI::class.java)

    @Provides
    @Singleton
    fun providesSolveAPI(retrofit: Retrofit): SolveAPI =
        retrofit.create(SolveAPI::class.java)

    @Provides
    @Singleton
    fun providesUserAPI(retrofit: Retrofit): UserAPI =
        retrofit.create(UserAPI::class.java)
}