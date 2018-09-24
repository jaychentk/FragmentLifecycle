package com.example.jaychen.fragmentlifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goEditText.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, EditTextFragment())
                    .addToBackStack(null).commit()
        }

        goRecyclerView.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.container, RecyclerViewFragment())
                    .addToBackStack(null).commit()
        }


    }
}
