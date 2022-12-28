package net.appitiza.lib.example

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.appitiza.net.example.R
import net.appitiza.lib.customalert.AlertDialogFragment
import net.appitiza.lib.customalert.AlertListDialogFragment
import net.appitiza.lib.customalert.ListModel
import net.appitiza.lib.customalert.enum.AlertTypes
import java.util.ArrayList

fun AppCompatActivity.showAlert(
    title: String = getString(R.string.app_name),
    message: String = "",
    type: AlertTypes = AlertTypes.INFO,
    positiveButtonText: String = "Okay",
    negativeButtonText: String = "Cancel",
    positiveButtonBGColor: Int = net.appitiza.lib.customalert.R.drawable.button_positive_bg,
    negativeButtonBGColor: Int = net.appitiza.lib.customalert.R.drawable.button_negative_bg,
    positiveButtonTextColor: Int = R.color.white,
    negativeButtonTextColor: Int = R.color.black,
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

fun AppCompatActivity.showListAlert(
    title: String = getString(R.string.app_name),
    message: String = "",
    content: ArrayList<ListModel> = arrayListOf(),
    type: AlertTypes = AlertTypes.INFO,
    shouldShowPositive: Boolean = true,
    shouldShowNegative: Boolean = false,
    positiveAction: (() -> Unit)? = null,
    negativeAction: (() -> Unit)? = null,
    itemClick: ((Int) -> Unit)? = null
) {
    val dialog = AlertListDialogFragment(
        title = title,
        message = message,
        content = content,
        itemTextColor = android.R.color.black,
        selectedBGColor = android.R.color.holo_green_light,
        unselectedColor = android.R.color.white,
        type = type,
        positiveButtonBGColor = net.appitiza.lib.customalert.R.drawable.button_positive_bg,
        negativeButtonBGColor = net.appitiza.lib.customalert.R.drawable.button_negative_bg,
        shouldShowPositive = shouldShowPositive,
        positiveButtonText = "Okay",
        shouldShowNegative = shouldShowNegative,
        negativeButtonText = "Cancel",
        positiveAction = positiveAction,
        negativeAction = negativeAction,
        itemClick = itemClick
    )

    dialog.show(supportFragmentManager, "Custom alert")
}


fun Fragment.showListAlert(
    title: String = getString(R.string.app_name),
    message: String = "",
    content: ArrayList<ListModel> = arrayListOf(),
    type: AlertTypes = AlertTypes.INFO,
    shouldShowPositive: Boolean = true,
    shouldShowNegative: Boolean = false,
    positiveAction: (() -> Unit)? = null,
    negativeAction: (() -> Unit)? = null,
    itemClick: ((Int) -> Unit)? = null
) {
    val dialog = AlertListDialogFragment(
        title = title,
        message = message,
        content = content,
        itemTextColor = android.R.color.white,
        selectedBGColor = android.R.color.holo_green_light,
        unselectedColor = android.R.color.white,
        type = type,
        shouldShowPositive = shouldShowPositive,
        positiveButtonText = "Okay",
        shouldShowNegative = shouldShowNegative,
        negativeButtonText = "Cancel",
        positiveAction = positiveAction,
        negativeAction = negativeAction,
        itemClick = itemClick
    )

    dialog.show(childFragmentManager, "Custom alert")
}