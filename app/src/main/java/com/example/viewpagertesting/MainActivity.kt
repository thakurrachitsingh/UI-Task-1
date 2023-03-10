package com.example.viewpagertesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    lateinit var bottomSheet: BottomSheet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }



    fun openBottomSheet(view: View) {
        bottomSheet = BottomSheet()
        bottomSheet.show(supportFragmentManager, bottomSheet.tag)
    }


}