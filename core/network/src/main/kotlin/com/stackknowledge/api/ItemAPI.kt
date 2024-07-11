package com.stackknowledge.api

import com.stackknowledge.dto.response.item.GetItemResponse
import remote.response.item.GetItemResponseModel
import retrofit2.http.GET

interface ItemAPI {
    @GET("/item")
    suspend fun getItem(): List<GetItemResponse>
}