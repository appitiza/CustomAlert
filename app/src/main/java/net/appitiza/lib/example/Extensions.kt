package net.appitiza.lib.example

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.appitiza.net.example.R
import net.appitiza.lib.customalert.AlertDialogFragment
import net.appitiza.lib.customalert.AlertEtDialogFragment
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

    val dialog = AlertDialogFragment.Builder()
        .title(title)
        .message(message)
        .alertType(type)
        .positiveButtonText(positiveButtonText)
        .negativeButtonText(negativeButtonText)
        .positiveButtonTextColor(positiveButtonTextColor)
        .negativeButtonTextColor(negativeButtonTextColor)
        .positiveButtonBGColor(positiveButtonBGColor)
        .negativeButtonBGColor(negativeButtonBGColor)
        .shouldShowPositive(shouldShowPositive)
        .shouldShowNegative(shouldShowNegative)
        .positiveAction(positiveAction)
        .negativeAction(negativeAction)
        .build()
    dialog.show(supportFragmentManager, "Custom alert")
}
fun AppCompatActivity.showInputAlert(
    title: String = getString(R.string.app_name),
    message: String = "",
    type: AlertTypes = AlertTypes.INFO,
    hint: String = "",
    etBGColor: Int = net.appitiza.lib.customalert.R.drawable.button_negative_bg,
    etHintTextColor: Int = R.color.black,
    etTextColor : Int = R.color.black,
    positiveButtonText: String = "Okay",
    negativeButtonText: String = "Cancel",
    positiveButtonBGColor: Int = net.appitiza.lib.customalert.R.drawable.button_positive_bg,
    negativeButtonBGColor: Int = net.appitiza.lib.customalert.R.drawable.button_negative_bg,
    positiveButtonTextColor: Int = R.color.white,
    negativeButtonTextColor: Int = R.color.black,
    shouldShowPositive: Boolean = true,
    shouldShowNegative: Boolean = false,
    positiveAction: ((String) -> Unit)? = null,
    negativeAction: (() -> Unit)? = null
) {
    val dialog = AlertEtDialogFragment.Builder()
        .title(title)
        .message(message)
        .alertType(type)
        .etHint(hint)
        .etBGColor(etBGColor)
        .etHintTextColor(etHintTextColor)
        .etTextColor(etTextColor)
        .positiveButtonText(positiveButtonText)
        .negativeButtonText(negativeButtonText)
        .positiveButtonTextColor(positiveButtonTextColor)
        .negativeButtonTextColor(negativeButtonTextColor)
        .positiveButtonBGColor(positiveButtonBGColor)
        .negativeButtonBGColor(negativeButtonBGColor)
        .shouldShowPositive(shouldShowPositive)
        .shouldShowNegative(shouldShowNegative)
        .positiveAction(positiveAction)
        .negativeAction(negativeAction)
        .build()
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


    val dialog = AlertListDialogFragment.Builder()
        .title(title)
        .message(message)
        .alertType(type)
        .shouldShowPositive(shouldShowPositive)
        .shouldShowNegative(shouldShowNegative)
        .positiveAction(positiveAction)
        .negativeAction(negativeAction)
        .content(content)
        .itemClick(itemClick)
        .build()

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
    val dialog = AlertListDialogFragment.Builder()
        .title(title)
        .message(message)
        .alertType(type)
        .shouldShowPositive(shouldShowPositive)
        .shouldShowNegative(shouldShowNegative)
        .positiveAction(positiveAction)
        .negativeAction(negativeAction)
        .content(content)
        .itemClick(itemClick)
        .build()

    dialog.show(childFragmentManager, "Custom alert")
}