package com.geneva.stamps

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat

class SquaresView : View, View.OnTouchListener {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)

    private val TAG: String = "SquaresView"
    private val squares = ArrayList<Square>()
    var squareSize = 50
    var defaultColor: Int = 0

    init {
        setOnTouchListener(this)
        defaultColor = ContextCompat.getColor(context, R.color.blue)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val squaresIterator = squares.iterator()
        squaresIterator.forEach {
            canvas.drawRect(it.rect, it.paint)
        }
    }

    fun setColor(color: Int) {
        defaultColor = color
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        Log.d(TAG, "onTouch() called with: v = $v, event = $event")
        if (event!!.action == MotionEvent.ACTION_DOWN) {
            addSquare(event.x.toInt(), event.y.toInt())
            invalidate()
        }
        return true
    }

    private fun addSquare(x: Int, y: Int) {
        Log.d(TAG, "drawSquare() called with: x = $x, y = $y")

        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = defaultColor

        var rect = Rect()
        rect.set(0, 0, squareSize, squareSize)
        rect.offsetTo(x - (squareSize / 2), y - (squareSize / 2))

        squares.add(Square(rect, paint))
    }
}

data class Square(
    val rect: Rect,
    val paint: Paint
)