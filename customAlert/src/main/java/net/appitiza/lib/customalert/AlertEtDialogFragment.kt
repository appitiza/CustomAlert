package net.appitiza.lib.customalert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import net.appitiza.lib.customalert.databinding.FragmentAlertDialogBinding
import net.appitiza.lib.customalert.databinding.FragmentAlertEtDialogBinding
import net.appitiza.lib.customalert.enum.AlertTypes
import kotlin.contracts.Returns


class AlertEtDialogFragment private constructor() : CustomAlert() {
    private var etBGColor: Int = R.color.default_positive_button_text_color
    private var etHintTextColor: Int = R.color.default_message_text_color
    private var etTextColor: Int = R.color.default_message_text_color
    private var etHint: String = ""
    private var positiveAction: ((String) -> Unit)? = null

    private var _binding: FragmentAlertEtDialogBinding? = null
    private val mBinding get() = _binding!!
    data class Builder(
        var title: String? = null,
        var titleTextColor: Int = R.color.default_title_text_color,
        var message: String? = null,
        var messageTextColor: Int = R.color.default_message_text_color,
        var alertBG: Int = R.drawable.default_alert_bg,
        var type: AlertTypes? = AlertTypes.NONE,
        var etBGColor: Int = R.color.default_positive_button_text_color,
        var etHintTextColor: Int = R.color.default_message_text_color,
        var etTextColor: Int = R.color.default_message_text_color,
        var etHint: String = "",
        var shouldShowPositive: Boolean? = true,
        var positiveButtonTextColor: Int = R.color.default_positive_button_text_color,
        var positiveButtonBGColor: Int = R.drawable.ripple_positive_btn,
        var positiveButtonText: String = "Okay",
        var shouldShowNegative: Boolean? = false,
        var negativeButtonTextColor: Int = R.color.default_negative_button_text_color,
        var negativeButtonBGColor: Int = R.drawable.ripple_negative_btn,
        var negativeButtonText: String = "Cancel",
        var positiveAction: ((String) -> Unit)? = null,
        var negativeAction: (() -> Unit)? = null
    )
    {
        fun title(title: String) = apply { this.title = title }
        fun titleTextColor(titleTextColor: Int) = apply { this.titleTextColor = titleTextColor }
        fun message(message: String) = apply { this.message = message }
        fun messageTextColor(messageTextColor: Int) =
            apply { this.messageTextColor = messageTextColor }

        fun background(alertBG: Int) = apply { this.alertBG = alertBG }
        fun alertType(type: AlertTypes) = apply { this.type = type }
        fun etBGColor(etBGColor: Int) = apply { this.etBGColor = etBGColor }
        fun etHintTextColor(etHintTextColor: Int) = apply { this.etHintTextColor = etHintTextColor }
        fun etTextColor(etTextColor: Int) = apply { this.etTextColor = etTextColor }
        fun etHint(etHint: String) = apply { this.etHint = etHint }
        fun shouldShowPositive(shouldShowPositive: Boolean) =
            apply { this.shouldShowPositive = shouldShowPositive }

        fun positiveButtonTextColor(positiveButtonTextColor: Int) =
            apply { this.positiveButtonTextColor = positiveButtonTextColor }

        fun positiveButtonBGColor(positiveButtonBGColor: Int) =
            apply { this.positiveButtonBGColor = positiveButtonBGColor }

        fun positiveButtonText(positiveButtonText: String) =
            apply { this.positiveButtonText = positiveButtonText }

        fun shouldShowNegative(shouldShowNegative: Boolean) =
            apply { this.shouldShowNegative = shouldShowNegative }

        fun negativeButtonTextColor(negativeButtonTextColor: Int) =
            apply { this.negativeButtonTextColor = negativeButtonTextColor }

        fun negativeButtonBGColor(negativeButtonBGColor: Int) =
            apply { this.negativeButtonBGColor = negativeButtonBGColor }

        fun negativeButtonText(negativeButtonText: String) =
            apply { this.negativeButtonText = negativeButtonText }

        fun positiveAction(positiveAction: ((String) -> Unit)?) =
            apply { this.positiveAction = positiveAction }

        fun negativeAction(negativeAction: (() -> Unit)?) =
            apply { this.negativeAction = negativeAction }


        fun build(): AlertEtDialogFragment {
            val dialog = AlertEtDialogFragment()
            dialog.title = title ?: ""
            dialog.titleTextColor = titleTextColor
            dialog.message = message ?: ""
            dialog.messageTextColor = messageTextColor
            dialog.alertBG = alertBG
            dialog.type = type ?: AlertTypes.NONE
            dialog.etHintTextColor = etHintTextColor
            dialog.etBGColor = etBGColor
            dialog.etTextColor = etTextColor
            dialog.etHint = etHint
            dialog.shouldShowPositive = shouldShowPositive ?: true
            dialog.positiveButtonTextColor = positiveButtonTextColor
            dialog.positiveButtonBGColor = positiveButtonBGColor
            dialog.positiveButtonText = positiveButtonText
            dialog.shouldShowNegative = shouldShowNegative ?: false
            dialog.negativeButtonTextColor = negativeButtonTextColor
            dialog.negativeButtonBGColor = negativeButtonBGColor
            dialog.negativeButtonText = negativeButtonText
            dialog.positiveAction = positiveAction
            dialog.negativeAction = negativeAction
            return dialog
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlertEtDialogBinding.inflate(inflater, container, false)

        this.setStyle(STYLE_NO_FRAME, R.style.CustomDialog)
        dialog!!.window?.setBackgroundDrawableResource(alertBG)
        mBinding.tvAlertHeading.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                titleTextColor
            )
        )
        mBinding.tvAlertContent.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                messageTextColor
            )
        )
        mBinding.etValue.hint = etHint
        mBinding.etValue.setTextColor(ContextCompat.getColor(requireContext(), etTextColor))
        mBinding.etValue.setBackgroundResource(etBGColor)
        mBinding.etValue.setHintTextColor(ContextCompat.getColor(requireContext(),etHintTextColor));

        mBinding.btnOkay.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                positiveButtonTextColor
            )
        )
        mBinding.btnOkay.setBackgroundResource(positiveButtonBGColor)
        mBinding.btnOkay.text = positiveButtonText
        mBinding.btnCancel.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                negativeButtonTextColor
            )
        )
        mBinding.btnCancel.setBackgroundResource(negativeButtonBGColor)
        mBinding.btnCancel.text = negativeButtonText

        mBinding.tvAlertHeading.text = title
        mBinding.tvAlertContent.text = message
        mBinding.btnOkay.visibility = if (shouldShowPositive) {
            View.VISIBLE
        } else {
            View.GONE
        }
        mBinding.btnCancel.visibility = if (shouldShowNegative) {
            View.VISIBLE
        } else {
            View.GONE
        }
        mBinding.ivLogo.setImageResource(getImage())
        mBinding.btnOkay.setOnClickListener {
            dismiss()
            positiveAction?.let { it -> it(mBinding.etValue.text.toString()) }
        }
        mBinding.btnCancel.setOnClickListener {
            dismiss()
            negativeAction?.invoke()
        }

        if (type == AlertTypes.NONE) {
            mBinding.ivLogo.visibility = View.GONE
        }
        return mBinding.root
    }

    private fun getImage(): Int {
        return when (type) {
            AlertTypes.POSITIVE -> {
                R.drawable.ic_alert_tick
            }

            AlertTypes.NEGATIVE -> {
                R.drawable.ic_alert_sad
            }

            AlertTypes.HELP -> {
                R.drawable.ic_alert_help
            }

            AlertTypes.INFO -> {
                R.drawable.ic_alert_info
            }

            AlertTypes.WARNING -> {
                R.drawable.ic_alert_warning
            }

            AlertTypes.NONE -> {
                R.drawable.ic_alert_warning
            }
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()

    }
}