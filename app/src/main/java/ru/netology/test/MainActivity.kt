package ru.netology.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.test.adapter.PostsAdapter
import ru.netology.test.databinding.ActivityMainBinding
import ru.netology.test.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val adapter = PostsAdapter ({
            viewModel.likeById(it.id) // Make sure you have implemented likeById in PostViewModel
        },{
            viewModel.shareCounter(it.id) // Make sure you have implemented likeById in PostViewModel
        })
        binding.list.adapter = adapter
        viewModel.data.observe(this) { posts ->
            adapter.submitList(posts)
        }
    }
}
