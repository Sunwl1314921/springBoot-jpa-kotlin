package com.mytest.kotlin.service.impl

import com.mytest.kotlin.bean.UserInfo
import com.mytest.kotlin.jpa.UserInfoRepository
import com.mytest.kotlin.service.UserInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserInfoServiceImpl : UserInfoService{
    @Autowired
    lateinit var userInfoRepository: UserInfoRepository

    override fun getUserInfoById(id: Int): UserInfo {
        return userInfoRepository.findOne(id)
    }
    override fun addUserInfo(userInfo: UserInfo): UserInfo  = userInfoRepository.save(userInfo)
}