package com.yaman.mvpvsmvvmvsmvc_demo.mvp_demo

import android.os.Handler
import com.yaman.mvpvsmvvmvsmvc_demo.mvp_demo.MainActivityMvpContract.Model.OnFinishedListener
import java.util.Random

class MainActivityMvpModel : MainActivityMvpContract.Model {
    // array list of strings from which 
    // random strings will be selected 
    // to display in the activity 
    private val arrayList = mutableListOf(
        "DSA Self Paced: Master the basics of Data Structures and Algorithms to solve complex problems efficiently. ",
        "Placement 100: This course will guide you for placement with theory,lecture videos, weekly assignments " +
                "contests and doubt assistance.",
        "Amazon SDE Test Series: Test your skill & give the final touch to your preparation before applying for " +
                "product based against like Amazon, Microsoft, etc.",
        "Complete Interview Preparation: Cover all the important concepts and topics required for the interviews. " +
                "Get placement ready before the interviews begin",
        "Low Level Design for SDE 1 Interview: Learn Object-oriented Analysis and Design to prepare for " +
                "SDE 1 Interviews in top companies"
    )

    // this method will invoke when 
    // user clicks on the button 
    // and it will take a delay of 
    // 1200 milliseconds to display next course detail 
    override fun getNextCourse(onFinishedListener: OnFinishedListener) {
        Handler().postDelayed({
            onFinishedListener.onFinished(randomString)
        }, 1200)
    }

    private val randomString: String
        // method to select random 
        get() {
            val random = Random()
            val index = random.nextInt(arrayList.size)
            return arrayList[index]
        }
}