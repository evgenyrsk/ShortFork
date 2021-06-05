package com.evgenyrsk.feature.aggregator.presentation.indicators

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Evgeny Rasskazov
 */
fun interface OnViewHolderClickListener<ViewHolder : RecyclerView.ViewHolder> {

    fun onViewHolderClick(view: View, holder: ViewHolder)
}
