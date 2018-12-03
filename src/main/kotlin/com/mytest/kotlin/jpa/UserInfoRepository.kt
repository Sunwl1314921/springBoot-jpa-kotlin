package com.mytest.kotlin.jpa

import com.mytest.kotlin.bean.UserInfo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserInfoRepository  : CrudRepository<UserInfo, Int> {
//    @Query("select userInfo from user_info as userInfo  where userInfo.name=:name")
//    fun getUserList(@Param("name") name: String): MutableList<UserInfo>
}