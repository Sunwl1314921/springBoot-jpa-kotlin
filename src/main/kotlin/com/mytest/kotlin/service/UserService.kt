package com.mytest.kotlin.service

import com.mytest.kotlin.bean.User

interface UserService {

    fun getUserById(id: Int): User

    fun getListByName(name: String): MutableList<User>

    fun addUser(user: User): User
}