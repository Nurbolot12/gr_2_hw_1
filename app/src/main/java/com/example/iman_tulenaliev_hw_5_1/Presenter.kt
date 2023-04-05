package com.example.iman_tulenaliev_hw_5_1

import android.content.Context
import android.widget.Toast

class Presenter {
    var model = CounterModel()
    lateinit var view: CounterView

    fun incrementCount() {
        model.increment()
        view.updateText(model.count.toString())
    }

    fun dicrementCount() {
        model.decrement()
        view.updateText(model.count.toString())
    }

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun checkCount(context: Context) {
        if (model.count == 10) {
            makeToast(context)
        } else if (model.count == 15) {
            view.makeGreenText(true)
        } else {
            view.makeGreenText(false)
        }
    }

    fun makeToast(context: Context) {
        Toast.makeText(context, "Поздравляем!", Toast.LENGTH_LONG).show()
    }

}
