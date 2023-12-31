package com.yaman.mvpvsmvvmvsmvc_demo.mvp_demo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yaman.mvpvsmvvmvsmvc_demo.R

class MainActivityMvp : AppCompatActivity() {
    // creating object of TextView class
    private var textView: TextView? = null

    // creating object of Button class
    private var button: Button? = null

    // creating object of ProgressBar class
    private var progressBar: ProgressBar? = null

    // creating object of Presenter interface in MainActivityMvpContract
    var presenter: MainActivityMvpContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning ID of the TextView
        textView = findViewById(R.id.textView)
        // assigning ID of the Button
        button = findViewById(R.id.button)
        // assigning ID of the ProgressBar
        progressBar = findViewById(R.id.progressBar)

        // instantiating object of Presenter Interface
        presenter = MainActivityMvpPresenter(mainView, MainActivityMvpModel())

        // operations to be performed when
        // user clicks the button
        button?.setOnClickListener {
            presenter?.onButtonClick()
        }
    }

    private val mainView = object : MainActivityMvpContract.View {
        override fun showProgress() {
            progressBar!!.visibility = View.VISIBLE
            textView!!.visibility = View.INVISIBLE
        }

        override fun hideProgress() {
            progressBar!!.visibility = View.GONE
            textView!!.visibility = View.VISIBLE
        }

        override fun setString(string: String?) {
            textView!!.text = string
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

}