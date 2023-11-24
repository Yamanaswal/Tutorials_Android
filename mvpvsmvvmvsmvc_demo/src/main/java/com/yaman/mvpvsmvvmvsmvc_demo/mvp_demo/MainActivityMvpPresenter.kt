package com.yaman.mvpvsmvvmvsmvc_demo.mvp_demo

import com.yaman.mvpvsmvvmvsmvc_demo.mvp_demo.MainActivityMvpContract.Model.OnFinishedListener

// instantiating the objects of View and Model Interface
// creating object of View Interface
class MainActivityMvpPresenter(
    private var mainView: MainActivityMvpContract.View?,
    private val mainModel: MainActivityMvpContract.Model
) : MainActivityMvpContract.Presenter, OnFinishedListener {
    // operations to be performed 
    // on button click 
    override fun onButtonClick() {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        mainModel.getNextCourse(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    // method to return the string 
    // which will be displayed in the 
    // Course Detail TextView 
    override fun onFinished(string: String?) {
        if (mainView != null) {
            mainView!!.setString(string)
            mainView!!.hideProgress()
        }
    }
}