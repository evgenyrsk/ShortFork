package com.evgenyrsk.feature.aggregator.presentation.indicators

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evgenyrsk.feature.aggregator.R
import com.evgenyrsk.feature.aggregator.databinding.ItemIndicatorInfoBinding
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorItem

/**
 * @author Evgeny Rasskazov
 */
class IndicatorsListAdapter(private val indicatorHelpClickListener: (item: IndicatorItem) -> Unit) :
    ListAdapter<IndicatorItem, IndicatorsListAdapter.ViewHolder>(IndicatorItemDiffCallback()),
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

        fun bindTo(item: IndicatorItem) {
            binding.name.text = item.name
            binding.value.text = item.readableValue

            val colorId = when (item.colouredValueIndicator) {
                IndicatorItem.Color.GOOD -> R.color.light_green_500
                IndicatorItem.Color.NEUTRAL -> R.color.yellow_500
                IndicatorItem.Color.BAD -> R.color.red_500
            }
            binding.valueColouredIndicator.setBackgroundColor(ContextCompat.getColor(itemView.context, colorId))
        }
    }
}

class IndicatorItemDiffCallback : DiffUtil.ItemCallback<IndicatorItem>() {

    override fun areItemsTheSame(oldItem: IndicatorItem, newItem: IndicatorItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: IndicatorItem, newItem: IndicatorItem): Boolean {
        return oldItem.name == newItem.name
    }
}
