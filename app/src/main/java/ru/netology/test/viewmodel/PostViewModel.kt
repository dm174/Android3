package ru.netology.test.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.test.repository.PostRepository
import ru.netology.test.repository.PostRepositoryInMemory

class PostViewModel :ViewModel(){
private val repository: PostRepository = PostRepositoryInMemory()

   val data =repository.getAll()
    fun likeById(id:Long)=repository.likeById(id)
    fun shareCounter(id: Long)=repository.shareCounter(id)
}