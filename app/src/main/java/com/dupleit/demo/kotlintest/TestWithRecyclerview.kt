package com.dupleit.demo.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_test_with_recyclerview.*

class TestWithRecyclerview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_with_recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?

        val users = ArrayList<User>()

        //adding some dummy data to the list
        users.add(User("Mandeep Singh", "Ambala, Haryana"))
        users.add(User("Khalil Ur Rehman", "Ambala, Haryana"))
        users.add(User("Faiz Khan", "Ambala, Haryana"))
        users.add(User("Yashar Khan", "Ambala, Haryana"))
        users.add(User("Mandeep Singh", "Ambala, Haryana"))
        users.add(User("Khalil Ur Rehman", "Ambala, Haryana"))
        users.add(User("Faiz Khan", "Ambala, Haryana"))
        users.add(User("Yashar Khan", "Ambala, Haryana"))
        users.add(User("Mandeep Singh", "Ambala, Haryana"))
        users.add(User("Khalil Ur Rehman", "Ambala, Haryana"))
        users.add(User("Faiz Khan", "Ambala, Haryana"))
        users.add(User("Yashar Khan", "Ambala, Haryana"))

        //creating our adapter
        val adapter = recyclerAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }
}
