package ru.netology.test.repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.test.dto.Post
class PostRepositoryInMemory: PostRepository {
    private var post = Post(
        1L,
        "Нетология.",
        "22.07.2023",
        "Привет! Это задание 4",
        true,
        1_000,
        1,
        true

    )
    private val data = MutableLiveData(post)
    override fun get():LiveData<Post> = data

    override fun favorite() {
    post = post.copy(likedByMe =!post.likedByMe, liked=if (post.likedByMe) post.liked - 1 else post.liked + 1 )
    data.value=post
}
    override fun share() {
        post = post.copy(repostByMe = !post.repostByMe, repost =  post.repost +1  )
         data.value=post
    }
}