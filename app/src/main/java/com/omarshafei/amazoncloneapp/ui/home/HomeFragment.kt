package com.omarshafei.amazoncloneapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.omarshafei.amazoncloneapp.R
import com.omarshafei.amazoncloneapp.data.models.Category
import com.omarshafei.amazoncloneapp.data.models.Offer
import com.omarshafei.amazoncloneapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoriesRecyclerView: RecyclerView
    private lateinit var offersRecyclerView: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var offersAdapter: OffersAdapter
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
        constructOffersRecyclerView()
        return binding.root
    }

    private fun initViews() {
        categoriesRecyclerView = binding.categoriesRecyclerView
        offersRecyclerView = binding.offersRecyclerView
    }

    private fun constructCategoriesRecyclerView() {
        categoriesAdapter = CategoriesAdapter(getCategoriesList())
        categoriesRecyclerView.adapter = categoriesAdapter
    }

    private fun constructOffersRecyclerView() {
        offersAdapter = OffersAdapter(getOffersList())
        offersRecyclerView.adapter = offersAdapter
    }

    private fun getCategoriesList(): MutableList<Category> {
        return mutableListOf(
            Category(imageResourceId = ResourcesCompat.getDrawable(resources, R.drawable.coupon,
                requireContext().theme)!! , "Coupons"),
            Category(imageResourceId = ResourcesCompat.getDrawable(resources, R.drawable.kitchen,
                requireContext().theme)!! , "Kitchen"),
            Category(imageResourceId = ResourcesCompat.getDrawable(resources, R.drawable.smart_watch,
                requireContext().theme)!! , "Electronics"),
            Category(imageResourceId = ResourcesCompat.getDrawable(resources, R.drawable.mobile,
                requireContext().theme)!! , "Mobiles"),
            Category(imageResourceId = ResourcesCompat.getDrawable(resources, R.drawable.laptop,
                requireContext().theme)!! , "Laptops"),
                    Category(imageResourceId = ResourcesCompat.getDrawable(resources, R.drawable.toys,
                requireContext().theme)!! , "Toys")
        )
    }

    private fun getOffersList(): MutableList<Offer> {
        return mutableListOf(
            Offer(imageResourceId = ResourcesCompat.getDrawable(resources, R.drawable.offer1,
                requireContext().theme)!! , "Clearance Sale | Up to 50% off"),
            Offer(imageResourceId = ResourcesCompat.getDrawable(resources, R.drawable.offer2,
                requireContext().theme)!! , "Fashion Weekend Deals | Up to 70% off"),
            Offer(imageResourceId = ResourcesCompat.getDrawable(resources, R.drawable.offer3,
                requireContext().theme)!! , "Kitchen appliances"),
            Offer(imageResourceId = ResourcesCompat.getDrawable(resources, R.drawable.offer4,
                requireContext().theme)!! , "Sports & Fitness")
        )
    }

    private fun constructImagesViewPagerAdapter() {
        val images = intArrayOf(
            R.drawable.laptop, R.drawable.toys,
            R.drawable.smart_watch, R.drawable.mobile
        )
        imageViewPager = binding.viewPagerMain
        imageViewPager.adapter = ImagePagerAdapter(requireContext(), images)
    }
}