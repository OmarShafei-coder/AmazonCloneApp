package com.omarshafei.amazoncloneapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omarshafei.amazoncloneapp.R
import com.omarshafei.amazoncloneapp.data.models.Category
import com.omarshafei.amazoncloneapp.databinding.CategoryListItemBinding

class CategoriesAdapter(private val list: MutableList<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var binding: CategoryListItemBinding? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list_item, parent, false)

        binding = CategoryListItemBinding.bind(view)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.CategoriesViewHolder, position: Int) {
        val category = list[position]
        holder.categoryImage?.setImageDrawable(category.imageResourceId)
        holder.categoryName?.text = category.name
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = binding?.image
        val categoryName = binding?.text
    }
}