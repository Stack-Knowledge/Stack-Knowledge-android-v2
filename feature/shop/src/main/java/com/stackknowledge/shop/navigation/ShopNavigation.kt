package com.stackknowledge.shop.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.shop.ShopRoute
import com.stackknowledge.shop.TeacherShopRoute

const val shopRoute = "shop_route"
const val teacherShopRoute = "teacher_shop_route"

fun NavController.navigateToShop(navOptions: NavOptions? = null) {
    this.navigate(shopRoute, navOptions)
}

fun NavGraphBuilder.shopScreen() {
    composable(route = shopRoute) {
        ShopRoute()
    }
}

fun NavController.navigateToTeacherShop(navOptions: NavOptions? = null) {
    this.navigate(teacherShopRoute, navOptions)
}

fun NavGraphBuilder.teacherShopScreen() {
    composable(route = teacherShopRoute) {
        TeacherShopRoute()
    }
}