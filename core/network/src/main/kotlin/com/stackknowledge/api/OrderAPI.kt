package com.stackknowledge.api

import com.stackknowledge.dto.request.order.ChangeOrderStatusRequest
import com.stackknowledge.dto.request.order.OrderRequest
import com.stackknowledge.dto.request.order.Orders
import com.stackknowledge.dto.response.order.ViewAllOrderResponse
import remote.request.order.ChangeOrderStatusRequestModel
import remote.request.order.OrderRequestModel
import remote.response.order.ViewAllOrderResponseModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface OrderAPI {
    @POST("/order")
    suspend fun order(
        @Body body: List<OrderRequest>,
    )

    @GET("/order")
    suspend fun viewAllOrder(): List<ViewAllOrderResponse>

    @PATCH("/order")
    suspend fun changeOrderStatus(
        @Body body: ChangeOrderStatusRequest,
    )
}