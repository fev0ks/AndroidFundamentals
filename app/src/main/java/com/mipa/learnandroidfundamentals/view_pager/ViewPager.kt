package com.mipa.learnandroidfundamentals.view_pager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val images = listOf(
            R.drawable.screenshot_1,
            R.drawable.screenshot_3,
            R.drawable.screenshot_2,
            R.drawable.screenshot_8,
            R.drawable.screenshot_9,
            R.drawable.screenshot_10,
            R.drawable.screenshot_12
        )

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter
//        val position = Int.MAX_VALUE / 2 - (Int.MAX_VALUE / 2 % images.size);
//        viewPager.setCurrentItem(position, false)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
            tab.badge
        }.attach()

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPager, "onTabReselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPager, "onTabUnselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPager, "onTabSelected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }
        })

//        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
//        viewPager.beginFakeDrag()
//        viewPager.fakeDragBy(-10f)
//        viewPager.endFakeDrag()
    }
}