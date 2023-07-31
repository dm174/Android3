package ru.netology.test.repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.test.dto.Post
class PostRepositoryInMemory: PostRepository {
    private var posts = listOf(
        Post(
        id =1,
        author = "Нетологи",
        content = "22.07.2023",
        published = "Привет! Это задание 4",
        likedByMe = true,
        1000,
        1,
        true

    ),Post(
            id=2,
            "Нетология.",
            "22.07.2023",
            "Привет! Это задание 4",
            true,
            1200,
            1,
            true

        )

    )
    private val data = MutableLiveData(posts)
    override fun getAll():LiveData<List<Post>> = data
    override fun likeById(id: Long) {
        posts=posts.map{
            if (it.id !=id) it else it.copy(likedByMe = !it.likedByMe)
        }
        data.value=posts
    }
    override fun shareCounter(id: Long) {
        posts=posts.map{
            if (it.id !=id) it else it.copy(repostByMe = !it.repostByMe)
        }
        data.value=posts
    }
}