package ru.netology.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.test.databinding.ActivityMainBinding

import ru.netology.test.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel by viewModels<PostViewModel>()
        viewModel.data.observe(this) { post ->


            with(binding) {
                author.text = post.author
                published.text = post.published
                textNetology.text = post.content
                likeNumber.text = post.liked.toString()
                shareNumber.text = post.repostByMe.toString()




                favoriteNumber.text = formatNumber(post.liked)
                favorite.setImageResource(if (post.likedByMe) R.drawable.ic_baseline_favorite_border_red else R.drawable.ic_baseline_favorite_border_24)



                shareNumber.text = post.repost.toString()
                if (post.repostByMe) {
                    share.setImageResource(R.drawable.ic_baseline_share_24)

                }

            }
        }
        binding.favorite.setOnClickListener {
            viewModel.favorite()
        }
        binding.share.setOnClickListener { viewModel.share()
        }
        println("onCreate $this")
    }

    override fun onStart() {
        super.onStart()
        println("onStart $this")
    }

    override fun onStop() {
        super.onStop()
        println("onStop $this")
    }

    override fun onResume() {
        super.onResume()
        println("onResume $this")
    }

    override fun onPause() {
        super.onPause()
        println("onPause $this")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy $this")
    }

}
