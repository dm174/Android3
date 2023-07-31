package ru.netology.test.repository

import androidx.lifecycle.LiveData
import ru.netology.test.dto.Post

interface PostRepository{
    fun getAll():LiveData<List<Post>>

    fun likeById(id:Long)
    fun shareCounter(id: Long)
}