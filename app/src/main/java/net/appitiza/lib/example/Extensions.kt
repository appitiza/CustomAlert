package net.appitiza.lib.example

import androidx.appcompat.app.AppCompatActivity
import com.appitiza.net.example.R
import net.appitiza.lib.customalert.AlertDialogFragment
import net.appitiza.lib.customalert.enum.AlertTypes

fun AppCompatActivity.showAlert(
    title: String = getString(R.string.app_name),
    message: String = "",
    type: AlertTypes = AlertTypes.INFO,
    positiveButtonText: String = "Okay",
    negativeButtonText: String = "Cancel",
    positiveButtonBGColor : Int = android.R.color.holo_blue_light,
    negativeButtonBGColor : Int = android.R.color.holo_red_light,
    positiveButtonTextColor : Int = R.color.white,
    negativeButtonTextColor : Int = R.color.black,
    shouldShowPositive: Boolean = true,
    shouldShowNegative: Boolean = false,
    positiveAction: (() -> Unit)? = null,
    negativeAction: (() -> Unit)? = null
) {
    val dialog = AlertDialogFragment(
        title = title,
        message = message,
        type = type,
        shouldShowPositive = shouldShowPositive,
        positiveButtonText = positiveButtonText,
        positiveButtonBGColor = positiveButtonBGColor,
        negativeButtonBGColor = negativeButtonBGColor,
        positiveButtonTextColor = positiveButtonTextColor,
        negativeButtonTextColor = negativeButtonTextColor,
        shouldShowNegative = shouldShowNegative,
        negativeButtonText = negativeButtonText,
        positiveAction = positiveAction,
        negativeAction = negativeAction
    )

    dialog.show(supportFragmentManager, "Custom alert")


}