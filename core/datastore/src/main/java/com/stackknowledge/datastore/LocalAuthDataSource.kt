package com.stackknowledge.datastore

import com.stackknowledge.model.remote.enumdatatype.Authority
import kotlinx.coroutines.flow.Flow

interface LocalAuthDataSource {
    //    AccessToken
    suspend fun getAccessToken(): Flow<String>

    suspend fun setAccessToken(accessToken: String)

    suspend fun removeAccessToken()

    //    AccessTime
    suspend fun getAccessTime(): Flow<String>

    suspend fun setAccessTime(accessTime: String)

    suspend fun removeAccessTime()

    //    RefreshToken
    suspend fun getRefreshToken(): Flow<String>

    suspend fun setRefreshToken(refreshToken: String)

    suspend fun removeRefreshToken()

    //    RefreshTime
    suspend fun getRefreshTime(): Flow<String>

    suspend fun setRefreshTime(refreshTime: String)

    suspend fun removeRefreshTime()

    //      Authority
    suspend fun setAuthorityInfo(authority: String)

    suspend fun getAuthorityInfo(): Flow<String>
}