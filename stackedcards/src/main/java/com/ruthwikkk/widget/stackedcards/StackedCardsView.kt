package com.ruthwikkk.widget.stackedcards

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout

class StackedCardsView : RelativeLayout {

    private var mHeight = 0
    private var mWidth = 0

    constructor(context: Context?) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onLayout(
        changed: Boolean,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ) {
        super.onLayout(changed, left, top, right, bottom)
        mWidth = width
        mHeight = height
    }

    override fun dispatchDraw(canvas: Canvas) {
        val save = canvas.save()
        val paint =
            Paint(Paint.ANTI_ALIAS_FLAG)
        paint.isAntiAlias = true
        paint.setShadowLayer(20f, 0f, 5f, Color.GRAY)
        setLayerType(View.LAYER_TYPE_SOFTWARE, paint)
        val rect = Rect(
            paddingLeft,
            paddingTop,
            mWidth - paddingRight,
            mHeight - paddingBottom
        )
        val rectF = RectF(rect)
        val trans1 =
            (mWidth - paddingStart - paddingEnd) * 5 / 200.toFloat()
        val trans2 =
            (mWidth - paddingStart - paddingEnd) * 10 / 200.toFloat()
        canvas.save()
        paint.color = -0x1 //red
        canvas.translate(trans2, 0f)
        canvas.scale(0.9f, 1f)
        canvas.drawRoundRect(rectF, 10f, 10f, paint)
        //super.onDraw(canvas);
        canvas.restore()
        canvas.save()
        paint.color = -0x1 //blue
        canvas.translate(trans1, 0f)
        canvas.scale(0.95f, 0.95f)
        canvas.drawRoundRect(rectF, 10f, 10f, paint)
        //super.onDraw(canvas);
        canvas.restore()
        canvas.save()
        paint.color = -0x9a5a5
        //super.onDraw(canvas);
        canvas.translate(0f, 0f)
        canvas.scale(1f, 0.9f)
        canvas.drawRoundRect(rectF, 10f, 10f, paint)
        val path = Path()
        path.addRoundRect(rectF, 10f, 10f, Path.Direction.CW)
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }
}