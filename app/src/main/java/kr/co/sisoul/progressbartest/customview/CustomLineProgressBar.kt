package kr.co.sisoul.progressbartest.customview

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ScaleDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setPadding
import kr.co.sisoul.progressbartest.R
import kr.co.sisoul.progressbartest.databinding.CustomProgressbarLineBinding
import kr.co.sisoul.progressbartest.databinding.CustomProgressbarRingBinding
import timber.log.Timber

class CustomLineProgressBar @JvmOverloads
constructor(context : Context, attrs: AttributeSet?=null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding by lazy { CustomProgressbarLineBinding.inflate(LayoutInflater.from(context), this, false ) }
    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomProgressBar,
            0, 0).apply {
            try {
                val ratio = getInt(R.styleable.CustomProgressBar_customProgressRatio, 5)
                setRatio(ratio)
            } finally {
                recycle()
                addView(binding.root)
            }
        }
    }

    fun setRatio(ratio : Int) {
        binding.lineProgressBar.progress = 0
        binding.lineProgressBarText.text = "${ratio}%"
        Log.d("ratio", "${ratio}")
        if (ratio < 10) {
            val newPD = ScaleDrawable(
                resources.getDrawable(R.drawable.line_progressbar, null),
                Gravity.LEFT,
                0f,
                0.1f * (10 - ratio)
            )
            binding.lineProgressBar.progressDrawable = newPD
            binding.lineProgressBar.progress = ratio
        } else {
            val newPD = ScaleDrawable(
                resources.getDrawable(R.drawable.line_progressbar, null),
                Gravity.LEFT,
                0f,
                -1f
            )
            binding.lineProgressBar.progressDrawable = newPD
            binding.lineProgressBar.progress = ratio
        }
    }
}