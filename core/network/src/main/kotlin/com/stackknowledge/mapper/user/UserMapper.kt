package com.stackknowledge.mapper.user

import com.stackknowledge.dto.user.User
import remote.user.UserModel

fun User.toModel(): UserModel =
    UserModel(
        id = this.id,
        name = this.name,
        profileImage = this.profileImage,
    )
