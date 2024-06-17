package graphs.bar.render

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import graphs.bar.BarChartData

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 19:32
 * @Version 1.0
 * @Description TO-DO
 */

class SimpleBarDrawer : IBarDrawer {
    private val mBarPaint by lazy { Paint().apply { isAntiAlias = true } }

    override fun drawBar(
        drawScope: DrawScope,
        canvas: Canvas,
        barArea: Rect,
        bar: BarChartData.Bar
    ) {
        canvas.drawRect(barArea, mBarPaint.apply { color = bar.color })
    }
}