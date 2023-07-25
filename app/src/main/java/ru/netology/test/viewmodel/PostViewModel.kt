package ru.netology.test.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.test.repository.PostRepository
import ru.netology.test.repository.PostRepositoryInMemory

class PostViewModel :ViewModel(){
private val repository: PostRepository = PostRepositoryInMemory()

    val data = repository.get()
    fun favorite()=repository.favorite()
}