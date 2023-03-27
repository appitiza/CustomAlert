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


class AlertEtDialogFragment(
    private val title: String,
    private val titleTextColor : Int = R.color.default_title_text_color,
    private val message: String,
    private val messageTextColor : Int = R.color.default_message_text_color,
    private val alertBG : Int = R.drawable.default_alert_bg,
    private val type: AlertTypes,
    private val etBGColor : Int = R.color.default_positive_button_text_color,
    private val etHintTextColor : Int = R.color.default_message_text_color,
    private val etTextColor : Int = R.color.default_message_text_color,
    private val etHint : String = "Value",
    private val shouldShowPositive: Boolean,
    private val positiveButtonTextColor : Int = R.color.default_positive_button_text_color,
    private val positiveButtonBGColor : Int = R.drawable.ripple_positive_btn,
    private val positiveButtonText : String = "Okay",
    private val shouldShowNegative: Boolean,
    private val negativeButtonTextColor : Int = R.color.default_negative_button_text_color,
    private val negativeButtonBGColor : Int = R.drawable.ripple_negative_btn,
    private val negativeButtonText : String = "Cancel",
    private val positiveAction: (() -> String)?,
    private val negativeAction: (() -> Unit)?
) : DialogFragment() {
    private var _binding: FragmentAlertEtDialogBinding? = null
    private val mBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlertEtDialogBinding.inflate(inflater, container, false)

        this.setStyle(STYLE_NO_FRAME, R.style.CustomDialog)
        dialog!!.window?.setBackgroundDrawableResource(alertBG)
        mBinding.tvAlertHeading.setTextColor(ContextCompat.getColor(requireContext(), titleTextColor))
        mBinding.tvAlertContent.setTextColor(ContextCompat.getColor(requireContext(), messageTextColor))
        mBinding.etValue.hint = etHint
        mBinding.etValue.setTextColor(ContextCompat.getColor(requireContext(), etTextColor))
        mBinding.etValue.setBackgroundResource(etBGColor)


        mBinding.btnOkay.setTextColor(ContextCompat.getColor(requireContext(), positiveButtonTextColor))
        mBinding.btnOkay.setBackgroundResource(positiveButtonBGColor)
        mBinding.btnOkay.text = positiveButtonText
        mBinding.btnCancel.setTextColor(ContextCompat.getColor(requireContext(), negativeButtonTextColor))
        mBinding.btnCancel.setBackgroundResource(negativeButtonBGColor)
        mBinding.btnCancel.text = negativeButtonText

        mBinding.tvAlertHeading.text = title
        mBinding.tvAlertContent.text = message
        mBinding.btnOkay.visibility = if(shouldShowPositive){
            View.VISIBLE
        }
        else{
            View.GONE
        }
        mBinding.btnCancel.visibility = if(shouldShowNegative){
            View.VISIBLE
        }
        else{
            View.GONE
        }
        mBinding.ivLogo.setImageResource(getImage())
        mBinding.btnOkay.setOnClickListener {
            dismiss()
            positiveAction?.invoke()
        }
        mBinding.btnCancel.setOnClickListener {
            dismiss()
            negativeAction?.invoke()
        }

        if(type == AlertTypes.NONE)
        {
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