package com.example.lifecyclelog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.title = "SuperMan"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        addFragment(FragmentA())
    }

    override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
        print("onMenuOpened")
        return super.onMenuOpened(featureId, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        print("onOptionsItemSelected : ${item?.itemId}")
        print("id: ${android.R.id.home}")
        return super.onOptionsItemSelected(item)
    }

    private fun print(message: String) {
        Timber.tag(getLogTag()).d(message)
    }

    private fun getLogTag() = "MainActivity"


    private fun addFragment(fragment: BaseFragment) {
        setTitle(fragment.getTitle())
        val fm = this.supportFragmentManager
        fm.beginTransaction().add(R.id.frame_layout, fragment, fragment.javaClass.simpleName).commit()
    }


    fun replaceFragment(fragment: BaseFragment) {
        setTitle(fragment.getTitle())
        val fm = this.supportFragmentManager
        fm.beginTransaction().replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName).addToBackStack("").commit()
    }

    fun setTitle(title: String) {
        if (title.isNotEmpty()) {
            supportActionBar?.title = title
        }
    }
}
