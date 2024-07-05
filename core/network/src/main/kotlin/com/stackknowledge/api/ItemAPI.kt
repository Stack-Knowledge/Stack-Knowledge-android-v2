package com.stackknowledge.api

import remote.response.item.GetItemResponseModel
import retrofit2.http.GET

interface ItemAPI {
    @GET("/item")
    suspend fun getItem(): List<GetItemResponseModel>
}