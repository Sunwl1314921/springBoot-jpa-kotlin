package com.mytest.kotlin.service

import com.mytest.kotlin.bean.UserInfo

interface UserInfoService {
    fun getUserInfoById(id: Int): UserInfo

    fun addUserInfo(userInfo: UserInfo): UserInfo
}