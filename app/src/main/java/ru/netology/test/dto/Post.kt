package ru.netology.test.dto

data class Post (
    val id:Long,
    val author:String,
    val content:String,
    val published:String,
    var likedByMe:Boolean,

    var liked:Int,
    var repost:Int,
    var repostByMe:Boolean
    )

