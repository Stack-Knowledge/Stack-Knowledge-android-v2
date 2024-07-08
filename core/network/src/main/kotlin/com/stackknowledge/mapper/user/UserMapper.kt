package com.stackknowledge.mapper.user

import com.stackknowledge.dto.user.User
import remote.user.UserModel

fun User.toModel(): UserModel =
    UserModel(
        userId = this.userId,
        name = this.name,
        profileImage = this.profileImage,
    )
