package com.mytest.kotlin.bean

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "user_info")
data class UserInfo(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = 0,
        var name: String = "",
        var age: Int = 0
): Serializable
