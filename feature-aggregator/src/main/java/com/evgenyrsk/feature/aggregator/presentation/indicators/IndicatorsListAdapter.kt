package com.evgenyrsk.feature.aggregator.presentation.indicators

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evgenyrsk.feature.aggregator.databinding.ItemIndicatorInfoBinding
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorListItem

/**
 * @author Evgeny Rasskazov
 */
class IndicatorsListAdapter(private val indicatorHelpClickListener: (item: IndicatorListItem) -> Unit) :
    ListAdapter<IndicatorListItem, IndicatorsListAdapter.ViewHolder>(IndicatorItemDiffCallback()),
    OnViewHolderClickListener<IndicatorsListAdapter.ViewHolder> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemIndicatorInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            this
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onViewHolderClick(view: View, holder: ViewHolder) {
        indicatorHelpClickListener.invoke(getItem(holder.adapterPosition))
    }

    class ViewHolder(
        private val binding: ItemIndicatorInfoBinding,
        private val viewHolderClickListener: OnViewHolderClickListener<ViewHolder>
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.helpIcon.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    viewHolderClickListener.onViewHolderClick(it, this)
                }
            }
        }

        fun bindTo(item: IndicatorListItem) {
            binding.name.text = item.name
            binding.value.text = item.readableValue
            binding.value.setTextColor(
                ContextCompat.getColor(
                    itemView.context,
                    item.color.colorCode
                )
            )
        }
    }
}

class IndicatorItemDiffCallback : DiffUtil.ItemCallback<IndicatorListItem>() {

    override fun areItemsTheSame(oldItem: IndicatorListItem, newItem: IndicatorListItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: IndicatorListItem,
        newItem: IndicatorListItem
    ): Boolean {
        return oldItem.name == newItem.name
    }
}
