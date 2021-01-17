package com.example.viewpager


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager


import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
   private val list = mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addToList()
        viewPager.adapter = Adapter(this,list)
        viewPager.addOnPageChangeListener(mlistener)
    }

    fun addToList() {
        for (i in 1..7) {
            val name_id = "cat_$i"
            val id = resources.getIdentifier(name_id, "drawable", packageName)
            list.add(id)
        }

    }


    val mlistener = object: ViewPager.OnPageChangeListener{
        override fun onPageScrollStateChanged(position: Int) {
            //頁面滑動狀態改變時
        }
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            //頁面滾動時觸發
            val page_position = position + 1  //position是從0開始
            textView.text = "$page_position/ ${list.size}"

        }
        override fun onPageSelected(position: Int) {
            //當新的頁面被選擇時
        }
    }

}