package com.example.lifecyclelog

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import timber.log.Timber

open class BaseFragment : Fragment() {

    private fun getLogTag(): String = javaClass.simpleName

    fun getTitle(): String = javaClass.simpleName


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        print("onAttach(context)")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        print("onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        print("onCreateView")

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        print("onResume")
    }

    override fun onStart() {
        super.onStart()
        print("onStart")
        (activity as MainActivity).setTitle(getTitle())
    }

    override fun onStop() {
        super.onStop()
        print("onStop()")
    }

    override fun onDetach() {
        super.onDetach()
        print("onDetach()")
    }

    private fun print(message: String) {
        Timber.tag(getLogTag()).d(message)
    }

}