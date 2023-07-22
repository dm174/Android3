package ru.netology.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.test.databinding.ActivityMainBinding
import ru.netology.test.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val post = Post(
            1L,
            "Нетология.",
            "22.07.2023",
            "Привет! Это задание 4",
            false,
            1_999,
        1,
        false
        )
        fun formatNumber(number: Int): String {
            return when {
                number < 1000 -> number.toString()
                number < 10_000 -> {
                    val decimalPart = (number % 1000) / 100
                    val integerPart = number / 1000
                    if (decimalPart == 0) {
                        String.format("%dK", integerPart)
                    } else {
                        String.format("%d,%dK", integerPart, decimalPart)
                    }
                }
                number < 1_000_000 -> {
                    val decimalPart = (number % 1000) / 100
                    val integerPart = number / 1000
                    if (decimalPart == 0) {
                        String.format("%dK", integerPart)
                    } else {
                        String.format("%dK", integerPart, decimalPart)
                    }
                }
                number < 100_000_000 -> {
                    val decimalPart = (number % 1_000_000) / 100_000
                    val integerPart = number / 1_000_000
                    if (decimalPart == 0) {
                        String.format("%dM", integerPart)
                    } else {
                        String.format("%d,%dM", integerPart, decimalPart)
                    }
                }
                else -> String.format("%.1fM", number / 1_000_000.0)
            }
        }

       with (binding) {
           author.text=post.author
           published.text =post.published
       textNetology.text=post.content

           favoriteNumber.text = formatNumber(post.liked)
       if (post.likedByMe){
           favorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
       }
           favorite.setOnClickListener {
           post.likedByMe = !post.likedByMe
           if (post.likedByMe) post.liked++ else post.liked--
   favorite.setImageResource(if(post.likedByMe)R.drawable.ic_baseline_favorite_border_red else R.drawable.ic_baseline_favorite_border_24)
               favoriteNumber.text = formatNumber(post.liked)
       }

           shareNumber.text= post.repost.toString()
           if (post.repostByMe){
               share.setImageResource(R.drawable.ic_baseline_favorite_border_24)
           }
           share.setOnClickListener {
               post.repostByMe = !post.repostByMe
                post.repost++
               shareNumber.text= post.repost.toString()
           }
       }

    }
}