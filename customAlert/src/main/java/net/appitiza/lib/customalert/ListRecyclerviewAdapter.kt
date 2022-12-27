package net.appitiza.lib.customalert

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import net.appitiza.lib.customalert.databinding.ItemAlertListBinding

class ListRecyclerviewAdapter(
    private val context: Context,
    private val itemTextColor: Int = R.color.default_title_text_color,
    private val selectedItemBGColor: Int = android.R.color.white,
    private val unSelectedItemBGColor: Int = android.R.color.white,
    private val onItemClick: ((Int) -> Unit)? = null
) :
    ListAdapter<ListModel, ListRecyclerViewHolder>(DiffUtilList()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRecyclerViewHolder {
        return ListRecyclerViewHolder.ListViewHolder(
            ItemAlertListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListRecyclerViewHolder, position: Int) {
        when (holder) {
            is ListRecyclerViewHolder.ListViewHolder -> holder.bind(
                item = getItem(position),
                context = context,
                itemTextColor = itemTextColor,
                selectedItemBGColor = selectedItemBGColor,
                unSelectedItemBGColor = unSelectedItemBGColor,
                onItemClick = onItemClick
            )
        }

    }


}