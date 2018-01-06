package com.dupleit.demo.kotlintest

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.dupleit.demo.kotlintest.Network.ApiClient
import com.dupleit.demo.kotlintest.Network.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = "SIGN UP"
        progressbar.visibility = View.GONE

        loginButton.setOnClickListener {

            if (validateData()) {
                hitApi()
            }
        }
    }

    private fun hitApi() {
        progressbar.visibility = View.VISIBLE
        val service = ApiClient.client!!.create(ApiService::class.java)
        val userCall = service.checkEmails(editTextEmail?.text.toString(), editTextPassword?.text.toString(), editTextName?.text.toString(), editTextMobile?.text.toString())
        userCall.enqueue(object : Callback<SignupModel> {
            override fun onResponse(call: Call<SignupModel>, response: Response<SignupModel>) {

                progressbar.visibility = View.GONE
                if (response.body().status) {
                    //Toast.makeText(applicationContext,""+ response.body().message, Toast.LENGTH_SHORT).show();
                    showSnackBar(response.body().message)
                } else {
                    showSnackBar(response.body().message)
                    //Toast.makeText(applicationContext, ""+response.body().message, Toast.LENGTH_SHORT).show();

                }
            }

            override fun onFailure(call: Call<SignupModel>, t: Throwable) {
                Log.d("onFailure", t.toString())
            }
        })

    }

    private fun validateData(): Boolean {
        if (editTextName?.text.isNullOrEmpty()) {
            editTextName?.error = "Please fill Name"
            return false
        }
        if (editTextMobile?.text.isNullOrEmpty()) {
            editTextMobile?.error = "Please fill Mobile"
            return false
        }else if (editTextMobile?.length()!=10) {
            editTextMobile?.error = "10 Digit required"
            return false
        }
        if (editTextEmail?.text.isNullOrEmpty()) {
            editTextEmail?.error = "Please fill email"
            return false
        }
        if (editTextPassword?.text.isNullOrEmpty()) {
            editTextPassword?.error = "Please fill Password"
            return false
        }else if (editTextPassword?.length()!! <4) {
            editTextPassword?.error = "Please fill storng password"
            return false
        }
        return true
    }
    fun showSnackBar(message: String) {
        val snackbar = Snackbar
                .make(layout_main, "" + message, Snackbar.LENGTH_LONG)

        snackbar.show()
    }

}
