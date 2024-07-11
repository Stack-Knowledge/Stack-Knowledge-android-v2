package com.stackknowledge.shop.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.shop.ShopRoute
import com.stackknowledge.shop.TeacherShopRoute
import enumdata.Authority

const val shopRoute = "shop_route"
const val teacherShopRoute = "teacher_shop_route"

fun NavController.navigateToShop(navOptions: NavOptions? = null) {
    this.navigate(shopRoute, navOptions)
}

fun NavGraphBuilder.shopScreen(
    onNavigate: (Authority, String) -> Unit,
) {
    composable(route = shopRoute) {
        ShopRoute(
            onNavigate = onNavigate
        )
    }
}

fun NavController.navigateToTeacherShop(navOptions: NavOptions? = null) {
    this.navigate(teacherShopRoute, navOptions)
}

fun NavGraphBuilder.teacherShopScreen(
    onNavigate: (Authority, String) -> Unit,
) {
    composable(route = teacherShopRoute) {
        TeacherShopRoute(
            onNavigate = onNavigate
        )
    }
}