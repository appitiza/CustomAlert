package net.appitiza.lib.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appitiza.net.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setClick()
    }

    private fun setClick() {
        mBinding.btnAlert.setOnClickListener {
            showAlert(
                title = "My Title",
                message = "My Message",
                shouldShowPositive = true,
                shouldShowNegative = true
            )
        }
    }
}