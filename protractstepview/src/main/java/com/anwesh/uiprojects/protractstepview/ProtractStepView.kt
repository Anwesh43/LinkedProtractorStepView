package com.anwesh.uiprojects.protractstepview

/**
 * Created by anweshmishra on 27/10/18.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.RectF
import android.graphics.Color
import android.content.Context

val nodes : Int = 5
val color : Int = Color.parseColor("#4CAF50")

fun Canvas.drawPSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / 3
    paint.strokeWidth = Math.min(w, h) / 60
    paint.strokeCap = Paint.Cap.ROUND
    paint.style = Paint.Style.STROKE
    save()
    translate(gap + i * gap, h / 2)
    for (j in 0..1) {
        val sc : Float = Math.min(0.5f, Math.max(0f, scale - 0.5f * j)) * 2
        val deg : Float = 120f * sc * (1 - 2 * j)
        paint.color = color
        save()
        rotate(deg)
        drawLine(0f, 0f, size, 0f, paint)
        restore()
        paint.color = Color.WHITE
        drawArc(RectF(-size, -size, size, size), 0f, deg, false, paint)
    }
    restore()
}

class ProtractStepView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}