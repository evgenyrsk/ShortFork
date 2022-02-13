package com.evgenyrsk.feature.aggregator.presentation.chart

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.evgenyrsk.feature.aggregator.R

/**
 * @author Evgeny Rasskazov
 * Created on 18.01.2022
 */
class ChartLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val axisPaint: Paint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.blue_700)
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }
    val path: Path = Path()

    // Cells dimension
    val xUnitsCount = 5
    val yUnitsCount = 5
    var cellWidth: Int = 0
    var cellHeight: Int = 0

    var yMax: Float = 0f
    var xMax: Float = 0f

    private var dataSet: MutableList<ChartDataPoint> = mutableListOf()
    private var normalizedDataSet: MutableList<ChartDataPoint> = mutableListOf()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        drawAxis(canvas, axisPaint)
        //drawChart(canvas, dataSet)
    }

    fun setData(dataSet: List<ChartDataPoint>) {
        yMax = dataSet.maxOfOrNull { it.y } ?: 0f
        xMax = dataSet.maxOfOrNull { it.x } ?: 0f
        this.dataSet.clear()
        this.dataSet.addAll(dataSet)
        invalidate()
    }

    private fun drawAxis(canvas: Canvas, paint: Paint) {
        canvas.drawLine(
            0f,
            height.toFloat() - axisPaint.strokeWidth / 2.0f,
            width.toFloat(),
            height.toFloat() - axisPaint.strokeWidth / 2.0f,
            paint
        )
        canvas.drawLine(
            0f + axisPaint.strokeWidth / 2.0f,
            height.toFloat(),
            0f + axisPaint.strokeWidth / 2.0f,
            0f,
            paint
        )
    }

//    private fun drawChart(canvas: Canvas, data: List<ChartDataPoint>) {
//        canvas.drawLine()
//    }
}

class ChartDataPoint(
    val x: Float,
    val y: Float
)

