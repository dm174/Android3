package ru.netology.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.test.R
import ru.netology.test.databinding.CardPostBinding
import ru.netology.test.dto.Post
import ru.netology.test.formatNumber

typealias OnLikeListener = (post: Post) -> Unit

class PostsAdapter(private val onLikeListener: OnLikeListener,private val onShareListener: OnLikeListener) :
    ListAdapter<Post, PostViewHolder>(PostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, onLikeListener, onShareListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}

class PostViewHolder(
    private val binding: CardPostBinding,
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnLikeListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likeNumber.text=post.liked.toString()
            shareNumber.text=post.repostByMe.toString()


           like.setImageResource(if(post.likedByMe)R.drawable.ic_baseline_favorite_border_red else R.drawable.ic_baseline_favorite_border_24)

            like.setOnClickListener {
                if (post.likedByMe) post.liked-- else post.liked++
                onLikeListener( post)

            }
            share.setImageResource(R.drawable.ic_baseline_share_24)
            share.setOnClickListener {
                post.repost++
                onShareListener(post)
            }
            shareNumber.text = post.repost.toString()
            favoriteNumber.text = formatNumber(post.liked)

        }
    }
}

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}
