package com.example.learn_android_7

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private val TAG = "mylog_Fragment"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //在括号里完成fragment实例化的操作
        replaceFragment(RightFragment())

        //用来实现点一次按钮切一个fragment的效果
        var buttonClickCount = 0

        //动态添加fragment
        val buttonFragment: Button = findViewById(R.id.buttonFragment)
        buttonFragment.setOnClickListener() {
            buttonClickCount +=1
            if ((buttonClickCount % 2) != 0) {
                //在括号里完成fragment实例化的操作
                replaceFragment(AnotherRightFragment())
                Log.v(TAG, "replace to AnotherRightFragment")
            } else {
                replaceFragment(RightFragment())
                Log.v(TAG, "replace to RightFragment")
            }
        }
    }

    fun replaceFragment(fragment: Fragment) {
        //获取fragmentManager, 在activity中可以直接通过getSupportFragmentManager获取.
        // 这里是kotlin,可以直接写supportFragmentManager
        val fragmentManager = supportFragmentManager
        //通过beginTransaction开启一个事务
        val transaction = fragmentManager.beginTransaction()
        //向 容器 内添加或者替换fragment，调用事务的replace()，参数有两个：一个是容器(布局)id, 一个是目标fragment(这里是传入的参数)
        transaction.replace(R.id.rightLayout, fragment)
        //调用transaction的commit()提交事务
        transaction.commit()
    }
}