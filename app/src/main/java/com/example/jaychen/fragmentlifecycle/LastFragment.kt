package com.example.jaychen.fragmentlifecycle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LastFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_last, container, false)
    }
}

class Plain( val simeple: Int?) {
    var  allByDefault : Int = 0
}

fun main(args: Array<String>) {
    val plain = Plain(simeple = null)
    println(plain)
}