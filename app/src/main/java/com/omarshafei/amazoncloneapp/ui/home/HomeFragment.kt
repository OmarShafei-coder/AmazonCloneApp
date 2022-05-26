package com.omarshafei.amazoncloneapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.omarshafei.amazoncloneapp.R
import com.omarshafei.amazoncloneapp.data.models.Category
import com.omarshafei.amazoncloneapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoriesRecyclerView: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var imageViewPager: ViewPager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initViews()
        constructCategoriesRecyclerView()
        constructImagesViewPagerAdapter()
        return binding.root
    }

    private fun initViews() {
        categoriesRecyclerView = binding.categoriesRecyclerView
    }

    private fun constructCategoriesRecyclerView() {
        categoriesAdapter = CategoriesAdapter(getCategoriesList())
        categoriesRecyclerView.adapter = categoriesAdapter
    }

    private fun getCategoriesList(): MutableList<Category> {
        return mutableListOf<Category>(
            Category(imageResourceId = resources.getDrawable(R.drawable.coupon,
                null) , "Coupons"),
            Category(imageResourceId = resources.getDrawable(R.drawable.kitchen,
                null) , "Kitchen"),
            Category(imageResourceId = resources.getDrawable(R.drawable.smart_watch,
                null) , "Electronics"),
            Category(imageResourceId = resources.getDrawable(R.drawable.mobile,
                null) , "Mobiles"),
            Category(imageResourceId = resources.getDrawable(R.drawable.laptop,
                null) , "Laptops"),
                    Category(imageResourceId = resources.getDrawable(R.drawable.toys,
                null) , "Toys")
        )
    }

    private fun constructImagesViewPagerAdapter() {
        val images = intArrayOf(
            R.drawable.toys, R.drawable.laptop,
            R.drawable.smart_watch, R.drawable.mobile
        )
        imageViewPager = binding.viewPagerMain
        imageViewPager.adapter = ImagePagerAdapter(requireContext(), images)
    }
}