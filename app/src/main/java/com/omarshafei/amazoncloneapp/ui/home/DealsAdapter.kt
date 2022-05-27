package com.omarshafei.amazoncloneapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omarshafei.amazoncloneapp.R
import com.omarshafei.amazoncloneapp.data.models.Deal
import com.omarshafei.amazoncloneapp.databinding.DealsListItemBinding

class DealsAdapter(private val list: MutableList<Deal>) :
    RecyclerView.Adapter<DealsAdapter.DealsViewHolder>() {

    private var binding: DealsListItemBinding? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DealsAdapter.DealsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deals_list_item, parent, false)

        binding = DealsListItemBinding.bind(view)
        return DealsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DealsAdapter.DealsViewHolder, position: Int) {
        val deal = list[position]
        holder.dealImage?.setImageDrawable(deal.imageResourceId)
        holder.dealDiscountPercentage?.text = deal.discountPercentage
        holder.dealPrice?.text = deal.price.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class DealsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dealImage = binding?.image
        val dealDiscountPercentage = binding?.discountPercentage
        val dealPrice = binding?.price
    }
}