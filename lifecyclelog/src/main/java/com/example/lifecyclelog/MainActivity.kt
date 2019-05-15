package com.example.lifecyclelog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(FragmentA())
    }

    private fun addFragment(fragment: BaseFragment) {
        val fm = this.supportFragmentManager
        fm.beginTransaction().add(R.id.frame_layout, fragment, fragment.javaClass.simpleName).commit()
    }


    fun replaceFragment(fragment: BaseFragment) {
        val fm = this.supportFragmentManager
        fm.beginTransaction().replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName).addToBackStack("").commit()
    }
}
