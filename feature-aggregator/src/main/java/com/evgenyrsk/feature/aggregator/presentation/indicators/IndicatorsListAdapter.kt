package com.evgenyrsk.feature.aggregator.presentation.indicators

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.evgenyrsk.feature.aggregator.R
import com.evgenyrsk.feature.aggregator.databinding.ItemIndicatorInfoBinding
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorItem
import kotlin.properties.Delegates

/**
 * @author Evgeny Rasskazov
 */
class IndicatorsListAdapter(private val indicatorHelpClickListener: (item: IndicatorItem) -> Unit) :
    RecyclerView.Adapter<IndicatorsListAdapter.ViewHolder>(),
    OnViewHolderClickListener<IndicatorsListAdapter.ViewHolder> {

    var itemsList: List<IndicatorItem> by Delegates.observable(emptyList()) { _, oldValue, newValue ->
        notifyChanges(oldValue, newValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemIndicatorInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            this
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size

    override fun onViewHolderClick(view: View, holder: ViewHolder) {
        indicatorHelpClickListener.invoke(itemsList[holder.adapterPosition])
    }

    private fun notifyChanges(oldList: List<IndicatorItem>, newList: List<IndicatorItem>) {
        val differences = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun getOldListSize(): Int = oldList.size

            override fun getNewListSize(): Int = newList.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition].name == newList[newItemPosition].name
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition] == newList[newItemPosition]
            }
        })
        differences.dispatchUpdatesTo(this)
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
                IndicatorItem.ColoredIndicator.GOOD -> R.color.light_green_500
                IndicatorItem.ColoredIndicator.NEUTRAL -> R.color.yellow_500
                IndicatorItem.ColoredIndicator.BAD -> R.color.red_500
            }
            binding.valueColouredIndicator.setBackgroundColor(ContextCompat.getColor(itemView.context, colorId))
        }
    }
}
