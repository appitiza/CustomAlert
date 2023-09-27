package net.appitiza.lib.customalert

import androidx.fragment.app.DialogFragment
import net.appitiza.lib.customalert.enum.AlertTypes

open class CustomAlert(): DialogFragment() {
    var title: String = ""
    var titleTextColor: Int = R.color.default_title_text_color
    var message: String = ""
    var messageTextColor: Int = R.color.default_message_text_color
    var alertBG: Int = R.drawable.default_alert_bg
    var type: AlertTypes = AlertTypes.NONE
    var shouldShowPositive: Boolean = true
    var positiveButtonTextColor: Int = R.color.default_positive_button_text_color
    var positiveButtonBGColor: Int = R.drawable.ripple_positive_btn
    var positiveButtonText: String = "Okay"
    var shouldShowNegative: Boolean = false
    var negativeButtonTextColor: Int = R.color.default_negative_button_text_color
    var negativeButtonBGColor: Int = R.drawable.ripple_negative_btn
    var negativeButtonText: String = "Cancel"
    var negativeAction: (() -> Unit)? = null

}