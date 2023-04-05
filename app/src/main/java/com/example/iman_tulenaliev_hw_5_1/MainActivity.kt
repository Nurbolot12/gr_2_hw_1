package com.example.iman_tulenaliev_hw_5_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.iman_tulenaliev_hw_5_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    var presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnIncrement.setOnClickListener {
                presenter.incrementCount()
            }
            btnDecrement.setOnClickListener {
                presenter.dicrementCount()
            }
        }
    }

    override fun updateText(count: String) {
        binding.tvCount.text = count
        presenter.checkCount(this)
    }

    override fun makeGreenText(green: Boolean) {
        if (green) {
            binding.tvCount.setTextColor(ContextCompat.getColor(this, R.color.green))
        } else {
            binding.tvCount.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }
}