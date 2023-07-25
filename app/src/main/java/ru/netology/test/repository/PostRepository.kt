package ru.netology.test.repository

import androidx.lifecycle.LiveData
import ru.netology.test.dto.Post

interface PostRepository{
    fun get():LiveData<Post>
    fun favorite()
}