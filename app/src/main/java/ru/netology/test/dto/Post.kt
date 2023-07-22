package ru.netology.test.dto

data class Post (
    val id:Long,
    val author:String,
    val published:String,
    val content:String,
    var likedByMe:Boolean,

    var liked:Int,
    var repost:Int,
    var repostByMe:Boolean
    )

