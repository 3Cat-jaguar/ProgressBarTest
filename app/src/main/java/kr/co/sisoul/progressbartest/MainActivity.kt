package kr.co.sisoul.progressbartest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import kr.co.sisoul.progressbartest.customview.CustomRingProgressBar
import kr.co.sisoul.progressbartest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.setRatioBtn.setOnClickListener {
            val ratio = binding.editRatio.text.toString().toInt()?:0
            binding.ringProgress.setRatio(ratio)
            binding.lineProgress.setRatio(ratio)
        }
        setContentView(binding.root)
    }
}