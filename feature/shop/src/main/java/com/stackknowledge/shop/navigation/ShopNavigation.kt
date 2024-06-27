package com.stackknowledge.shop.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.shop.ShopRoute
import com.stackknowledge.shop.TeacherShopRoute

const val shop = "shop_route"
const val teacherShop = "teacher_shop_route"

fun NavController.navigateToShop(navOptions: NavOptions? = null) {
    this.navigate(shop, navOptions)
}

fun NavGraphBuilder.shopScreen() {
    composable(route = shop) {
        ShopRoute()
    }
}

fun NavController.navigateToTeacherShop(navOptions: NavOptions? = null) {
    this.navigate(teacherShop, navOptions)
}

fun NavGraphBuilder.teacherShopScreen() {
    composable(route = teacherShop) {
        TeacherShopRoute()
    }
}