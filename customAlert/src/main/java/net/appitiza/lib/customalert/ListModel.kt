package net.appitiza.lib.customalert

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListModel(
    var id: Int? = 0,
    var displayName: String? = "",
    var isSelected: Boolean? = false,
) : Parcelable