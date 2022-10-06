package kr.co.sisoul.progressbartest.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kr.co.sisoul.progressbartest.R
import kr.co.sisoul.progressbartest.databinding.CustomProgressbarRingBinding

class CustomRingProgressBar @JvmOverloads
constructor(context : Context, attrs: AttributeSet?=null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding by lazy { CustomProgressbarRingBinding.inflate(LayoutInflater.from(context), this, false ) }
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
        binding.ringProgressBar.progress = ratio
        binding.ringProgressBarText.text = "${ratio}%"
    }
}