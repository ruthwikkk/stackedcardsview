package com.ruthwikkk.widget.stackedcards


import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat


class StackedCardsView : RelativeLayout {

    private var mHeight = 0
    private var mWidth = 0
    private var cornerRadius = 0f
    private var scaleFactor = 0.1f
    private var translationFactor = scaleFactor/2
    private var bgColor = 0
    private var fgColor = 0
    private var cardDirection : Direction = Direction.BOTTOM

    enum class Direction {
        LEFT, TOP,RIGHT, BOTTOM
    }

    constructor(context: Context?) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init(attrs, defStyleAttr)
    }


    fun init(attrs: AttributeSet?, defStyle: Int = 0){
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.StackedCardsView)
        val array = context.obtainStyledAttributes(attrs, R.styleable.StackedCardsView, defStyle, 0)
        scaleFactor = attributes.getFloat(R.styleable.StackedCardsView_scv_scaleFactor, 0.1f)
        cornerRadius = attributes.getDimension(R.styleable.StackedCardsView_scv_cardRadius, 15f)
        bgColor = array.getColor(R.styleable.StackedCardsView_scv_backgroundCardColor, getColor(R.color.white_f0))
        fgColor = array.getColor(R.styleable.StackedCardsView_scv_foregroundCardColor, getColor(R.color.white_f0))
        cardDirection = Direction.values()[array.getInt(R.styleable.StackedCardsView_scv_cardPosition,3)]
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        mWidth = width
        mHeight = height
    }

    override fun dispatchDraw(canvas: Canvas) {
        when(cardDirection){
            Direction.LEFT -> renderLeft(canvas)
            Direction.TOP -> renderTop(canvas)
            Direction.RIGHT -> renderRight(canvas)
            Direction.BOTTOM -> renderBottom(canvas)

        }
    }

    private fun renderLeft(canvas: Canvas){
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
            (mWidth - paddingStart - paddingEnd) * scaleFactor / 2.toFloat()
        val trans2 =
            (mWidth - paddingStart - paddingEnd) * scaleFactor
        canvas.save()
        paint.color = bgColor
        canvas.translate(0f, trans2)
        canvas.scale( 1 - (2 * scaleFactor), 1 - (2 * scaleFactor))
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        //super.onDraw(canvas);
        canvas.restore()
        canvas.save()


        paint.color = bgColor
        canvas.translate(trans1, trans1)
        canvas.scale( 1 - scaleFactor, 1 - scaleFactor )
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        //super.onDraw(canvas);
        canvas.restore()
        canvas.save()


        paint.color = fgColor
        //super.onDraw(canvas);
        canvas.translate(trans2, 0f)
        canvas.scale( 1 - scaleFactor, 1f)
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        val path = Path()
        path.addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW)
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }

    private fun renderTop(canvas: Canvas){
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
        val translationX1 =
            (mWidth - paddingStart - paddingEnd) * scaleFactor / 2.toFloat()
        val translationX2 =
            (mWidth - paddingStart - paddingEnd) * scaleFactor
        canvas.save()
        paint.color = bgColor
        canvas.translate(translationX2, 0f)
        canvas.scale(1 - (2 * scaleFactor), 1 - (2 * scaleFactor))  //scale for card 3
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        //super.onDraw(canvas);
        canvas.restore()
        canvas.save()


        paint.color = bgColor
        canvas.translate(translationX1, translationX1)
        canvas.scale(1 - scaleFactor, 1 - scaleFactor) //scale for card 2
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        //super.onDraw(canvas);
        canvas.restore()
        canvas.save()


        paint.color = fgColor
        //super.onDraw(canvas);
        canvas.translate(0f, translationX2)
        canvas.scale(1f, 1 - (2 * translationFactor)) //scale for card 1
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        val path = Path()
        path.addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW)
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }

    private fun renderRight(canvas: Canvas){
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
            (mWidth - paddingStart - paddingEnd) * scaleFactor / 2.toFloat()
        val trans2 =
            (mWidth - paddingStart - paddingEnd) * scaleFactor
        canvas.save()
        paint.color = bgColor
        canvas.translate(0f, trans2)
        canvas.scale( 1f, 1 - (2 * scaleFactor))
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        //super.onDraw(canvas);
        canvas.restore()
        canvas.save()


        paint.color = bgColor
        canvas.translate(0f, trans1)
        canvas.scale( 1 - translationFactor, 1 - scaleFactor)
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        //super.onDraw(canvas);
        canvas.restore()
        canvas.save()


        paint.color = fgColor
        //super.onDraw(canvas);
        canvas.translate(0f, 0f)
        canvas.scale( 1 - (2 * translationFactor), 1f)
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        val path = Path()
        path.addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW)
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }

    private fun renderBottom(canvas: Canvas){
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
        val translationX1 =
            (mWidth - paddingStart - paddingEnd) * scaleFactor / 2.toFloat()
        val translationX2 =
            (mWidth - paddingStart - paddingEnd) * scaleFactor
        canvas.save()
        paint.color = bgColor
        canvas.translate(translationX2, 0f)
        canvas.scale(1 - (2 * scaleFactor), 1f)  //scale for card 3
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        //super.onDraw(canvas);
        canvas.restore()
        canvas.save()


        paint.color = bgColor
        canvas.translate(translationX1, 0f)
        canvas.scale(1 - scaleFactor, 1 - translationFactor) //scale for card 2
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        //super.onDraw(canvas);
        canvas.restore()
        canvas.save()


        paint.color = fgColor
        //super.onDraw(canvas);
        canvas.translate(0f, 0f)
        canvas.scale(1f, 1 - (2 * translationFactor)) //scale for card 1
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
        val path = Path()
        path.addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW)
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }


    private fun getColor(colorId: Int): Int {
        return if (Build.VERSION.SDK_INT >= 23) {
            context.getColor(colorId)
        } else {
            ContextCompat.getColor(context, colorId)
        }
    }
}