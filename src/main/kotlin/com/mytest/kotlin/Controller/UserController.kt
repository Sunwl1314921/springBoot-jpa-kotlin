package com.mytest.kotlin.Controller

import com.mytest.kotlin.bean.User
import com.mytest.kotlin.bean.UserInfo
import com.mytest.kotlin.service.UserInfoService
import com.mytest.kotlin.service.UserService
import com.mytest.kotlin.service.impl.UserInfoServiceImpl
import com.mytest.kotlin.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @Autowired
    lateinit var userServiceImpl: UserServiceImpl
    @Autowired
    lateinit var userInfoServiceImpl: UserInfoServiceImpl

    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, String>

    @GetMapping("/")
    fun get(): String = redisTemplate.opsForValue().get("sher")

    @Transactional
    @GetMapping("add2")
    fun addUser2(): UserInfo? {

        val user = UserInfo(name = "sher3333",age = 12)
        val u =  userInfoServiceImpl.addUserInfo(user)

        val a = 2/0;

        val user2 = User(name = "sher3333")
        val us =userServiceImpl.addUser(user2)

        return u
    }

    @GetMapping("add")
    fun addUser(): User? {
        val user = User(name = "sher2222")

        val us =userServiceImpl.addUser(user)

        val a = 2/0;

        val user2 = UserInfo(name = "sher2222",age = 12)
        userInfoServiceImpl.addUserInfo(user2)
        return us


    }







    @GetMapping("/all")
    fun addAll(): Int {
        val list = arrayListOf(User(1, "张三"), User(2, "李四"), User(3, "王五"), User(5, "赵六"))
        for (user in list) {
            userServiceImpl.addUser(user)
        }
        return list.size
    }

    @GetMapping("findone/{id}")
    fun findAllUser(@PathVariable id: Int, model: Model) = userServiceImpl.getUserById(id)

    @GetMapping("find/{name}")
    fun findByName(@PathVariable name: String) = userServiceImpl.getListByName(name)

    @GetMapping("get/{name}")
    fun getName(@PathVariable name: String) = userServiceImpl.getUserListByName(name)

    @GetMapping("get1/{name}")
    fun getList(@PathVariable name: String) = userServiceImpl.getAlluserListByName(name)
//
//    @GetMapping("send/{msg}")
//    fun sendMsg(@PathVariable msg:String)=userServiceImpl.sendMsg(msg)
}

fun main(args: Array<String>) {
    val list = arrayListOf(User(1, "22"), User(2, "ss"), User(3, "aa"), User(5, "qwe"))
//    println(list.size)
//    println(list.stream().count())
//    list.forEach(::println)
//    val sum = list.stream().mapToInt(User::id).sum()
//    println(sum)
//    val list1 = list.stream().filter { t: User -> t.id > 1 }.collect(Collectors.toList())
//    list1.forEach(::println)
//    val collect = list.stream().map(User::name).collect(Collectors.toList())
//    println(collect)
//    val entries = list.stream().collect(Collectors.groupingBy(User::id))
//    println(entries)
    val list2 = arrayListOf(1, 2, 3)
    list2.forEach { if (it == 2) return@forEach print(it) }
    list2.set(2, 31)
    println(list2)
    println(list2.subList(1, 2))


}


