package com.example.jaychen.fragmentlifecycle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_edit_text.*

class EditTextFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        print("onCreateView $view")
        return inflater.inflate(R.layout.fragment_edit_text, container, false)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        print("onViewStateRestored $savedInstanceState")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("key", "value")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container, LastFragment())?.addToBackStack(null)?.commit()
        }
    }

    override fun onDestroyView() {
        print("onDestroyView")
        super.onDestroyView()
    }
}

fun Fragment.print(content: String) {
    Log.d(javaClass.simpleName, content)
}