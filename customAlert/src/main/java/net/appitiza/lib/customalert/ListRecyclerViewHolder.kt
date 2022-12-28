package net.appitiza.lib.customalert

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import net.appitiza.lib.customalert.databinding.ItemAlertListBinding


sealed class ListRecyclerViewHolder(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    class ListViewHolder(private val binding: ItemAlertListBinding) :
        ListRecyclerViewHolder(binding) {

        fun bind(
            item: ListModel,
            context: Context,
            itemTextColor: Int = R.color.default_title_text_color,
            selectedItemBGColor: Int = android.R.color.white,
            unSelectedItemBGColor: Int = android.R.color.white,
            onItemClick: ((Int) -> Unit)?,
        ) {

            binding.tvTitle.setTextColor(ContextCompat.getColor(context, itemTextColor))
            binding.tvTitle.text = item.displayName
            if (item.isSelected == true) {
                binding.flRoot.setBackgroundResource(
                    selectedItemBGColor
                )
            } else {
                binding.flRoot.setBackgroundResource(
                    unSelectedItemBGColor
                )
            }
            binding.flRoot.setOnClickListener {
                onItemClick?.invoke(adapterPosition)
            }


        }


    }
}
