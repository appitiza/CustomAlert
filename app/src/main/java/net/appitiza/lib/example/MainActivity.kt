package net.appitiza.lib.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.appitiza.net.example.databinding.ActivityMainBinding
import net.appitiza.lib.customalert.ListModel
import net.appitiza.lib.customalert.enum.AlertTypes

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
        mBinding.btnListAlert.setOnClickListener {
            val list = arrayListOf<ListModel>()
            list.add(ListModel(1, "Option 1",false))
            list.add(ListModel(2, "Option 2",true))
            showListAlert(
                content = list,
                type = AlertTypes.INFO,
                shouldShowPositive = false,
                shouldShowNegative = true,
                itemClick = {
                    Toast.makeText(this, list[it].displayName, Toast.LENGTH_LONG).show()
                })
        }
    }
}