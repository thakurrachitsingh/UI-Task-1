package com.example.viewpagertesting

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheet : BottomSheetDialogFragment() {


    lateinit var adapter : MyPagerAdapter
    lateinit var viewPager2: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val crrView = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        viewPager2 = crrView.findViewById<RecyclerView>(R.id.viewPager2)
        val addToBoxButton = crrView.findViewById<Button>(R.id.button)
        addToBoxButton.setBackgroundColor(getResources().getColor(R.color.black))
        //addToBoxButton.setBackgroundResource(R.drawable.button_shaper)
        initializeAdapter()
        return crrView
    }

    private fun initializeAdapter() {
        val list = listOf<Int>(R.drawable.pants, R.drawable.pants, R.drawable.pants, R.drawable.pants, R.drawable.pants)
        viewPager2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        adapter = MyPagerAdapter(list, requireContext())
        viewPager2.adapter = adapter

    }



    companion object {
        const val tag = "BottomSheet"
    }
}