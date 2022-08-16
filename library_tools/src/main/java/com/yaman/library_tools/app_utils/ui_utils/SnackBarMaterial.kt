package com.yaman.library_tools.app_utils.ui_utils

import android.content.Context
import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

class SnackBarMaterial(val view: View, private val title: CharSequence) {

    private lateinit var snackBar: Snackbar

    /**
     * Snack Bar Init.
     * */
    private fun initSnackBar() {
        snackBar = Snackbar.make(view, title, Snackbar.LENGTH_SHORT)
    }

    fun showShort() {
        snackBar.duration = Snackbar.LENGTH_SHORT
        snackBar.show()
    }

    fun showLong() {
        snackBar.duration = Snackbar.LENGTH_LONG
        snackBar.show()
    }

    fun showInfinite() {
        snackBar.duration = Snackbar.LENGTH_INDEFINITE
        snackBar.show()
    }

    fun setAction(resString: String, listener: View.OnClickListener) {
        snackBar.setAction(resString, listener)
    }

    init {
        initSnackBar()
    }


}