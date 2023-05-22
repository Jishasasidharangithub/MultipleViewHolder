package com.template.tmp02.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.template.tmp02.R
import com.template.tmp02.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    private  var binding: ActivitySplashScreenBinding? = null
    private val SPLASH_TIME_OUT: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window?.statusBarColor = Color.TRANSPARENT
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        window?.decorView?.systemUiVisibility = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        else View.VISIBLE
        window?.statusBarColor = Color.WHITE
    }

    private fun init() {
        lifecycleScope.launch {
            delay(SPLASH_TIME_OUT)
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
            overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
        }
    }
}