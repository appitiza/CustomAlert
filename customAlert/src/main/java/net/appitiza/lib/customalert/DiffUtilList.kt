package net.appitiza.lib.customalert

import androidx.recyclerview.widget.DiffUtil

class DiffUtilList : DiffUtil.ItemCallback<ListModel>() {
    override fun areItemsTheSame(
        oldItem: ListModel,
        newItem: ListModel
    ): Boolean {
        return (oldItem == newItem)

    }

    override fun areContentsTheSame(
        oldItem: ListModel,
        newItem: ListModel
    ): Boolean {
        return oldItem.id == newItem.id
    }
}