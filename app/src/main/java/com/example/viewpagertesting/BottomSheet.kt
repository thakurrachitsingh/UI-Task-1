package com.example.viewpagertesting

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ms.square.android.expandabletextview.ExpandableTextView
import org.w3c.dom.Text


class BottomSheet : BottomSheetDialogFragment() {
    private var x = 0
    lateinit var crrView :View
    lateinit var adapter : MyPagerAdapter
    lateinit var viewPager2: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        crrView = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        viewPager2 = crrView.findViewById<RecyclerView>(R.id.viewPager2)
        val addToBoxButton = crrView.findViewById<Button>(R.id.button)
        addToBoxButton.setBackgroundColor(getResources().getColor(R.color.black))
        initializeAdapter()
        expandableFunctionality(crrView)

        return crrView
    }




    private fun initializeAdapter() {
        val list = listOf<Int>(R.drawable.pants, R.drawable.pants, R.drawable.pants, R.drawable.pants, R.drawable.pants)
        viewPager2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        adapter = MyPagerAdapter(list, requireContext())
        viewPager2.adapter = adapter

    }


    private fun expandableFunctionality(crrView : View) {
        crrView.findViewById<TextView>(R.id.expandableHead1).setOnClickListener { iconAndVisibilityChanger(crrView.findViewById(R.id.expandableHead1), crrView.findViewById(R.id.expandableBody1)) }
        crrView.findViewById<TextView>(R.id.expandableHead2).setOnClickListener { iconAndVisibilityChanger(crrView.findViewById<TextView>(R.id.expandableHead2), crrView.findViewById(R.id.expandableBody2)) }
    }

    private fun iconAndVisibilityChanger(head : TextView, body : TextView) {
        if(head.tag=="+"){
            head.tag = "-"
            head.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_add_24, 0)
            body.visibility = View.GONE
        }else{
            head.tag = "+"
            head.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.minimizer_shape,0)
            body.visibility = View.VISIBLE
        }
    }


    companion object {
        const val tag = "BottomSheet"
    }
}