package com.geneva.stamps

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var squaresView: SquaresView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        squaresView = findViewById(R.id.squares_view)

        button_blue.setOnClickListener(this)
        button_green.setOnClickListener(this)
        button_red.setOnClickListener(this)
        button_yellow.setOnClickListener(this)

        // set default color
        onClick(button_green)
    }

    override fun onClick(v: View?) {
        clearButtonScales()
        var color = 0
        when (v!!.id) {
            R.id.button_blue -> {
                color = ContextCompat.getColor(this, R.color.blue)
                setButtonPressedScale(button_blue)
            }
            R.id.button_green -> {
                color = ContextCompat.getColor(this, R.color.green)
                setButtonPressedScale(button_green)
            }
            R.id.button_red -> {
                color = ContextCompat.getColor(this, R.color.red)
                setButtonPressedScale(button_red)
            }
            R.id.button_yellow -> {
                color = ContextCompat.getColor(this, R.color.yellow)
                setButtonPressedScale(button_yellow)
            }
        }
        squaresView.setColor(color)
    }

    private fun setButtonPressedScale(view: View) {
        view.scaleY = 0.8f
        view.scaleX = 0.8f
    }

    private fun clearButtonPressedScale(view : View) {
        view.scaleY = 1f
        view.scaleX = 1f
    }

    private fun clearButtonScales() {
        clearButtonPressedScale(button_blue)
        clearButtonPressedScale(button_green)
        clearButtonPressedScale(button_red)
        clearButtonPressedScale(button_yellow)
    }
}
