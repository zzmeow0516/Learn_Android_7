package com.example.learn_android_7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

//fragment类是一定要定义的。因为在activity_main.xml中用到了leftfragment，因此需要xml中用到了leftfragment能够实例化
//否则报错：Unable to instantiate fragment com.example.learn_android_7.LeftFragment: make sure class name exists, is public
class LeftFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.left_fragment, container, false)
    }
}