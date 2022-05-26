package com.omarshafei.amazoncloneapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omarshafei.amazoncloneapp.R
import com.omarshafei.amazoncloneapp.data.models.Offer
import com.omarshafei.amazoncloneapp.databinding.OffersItemBinding

class OffersAdapter(private val list: MutableList<Offer>) :
    RecyclerView.Adapter<OffersAdapter.OffersViewHolder>() {

    private var binding: OffersItemBinding? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OffersAdapter.OffersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.offers_item, parent, false)

        binding = OffersItemBinding.bind(view)
        return OffersViewHolder(view)
    }

    override fun onBindViewHolder(holder: OffersAdapter.OffersViewHolder, position: Int) {
        val offer = list[position]
        holder.offerImage?.setImageDrawable(offer.imageResourceId)
        holder.offerName?.text = offer.name
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OffersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val offerImage = binding?.image
        val offerName = binding?.text
    }
}