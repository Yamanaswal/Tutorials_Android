package com.yaman.library_tools.app_utils.snackbar_custom

import android.view.View
import com.google.android.material.snackbar.Snackbar

class SnackBarCustom(builder: Builder) {

    private val snackBarView: View = builder.snackBarView // required
    private var snackBarMessage: String = builder.snackBarMessage // optional
    private var snackBarLength: Int = builder.snackBarLength // optional

    val snackBar: Snackbar = builder.snackBar!! // snack instance.

    class Builder(var snackBarView: View,var snackBarMessage: String) {

        internal var snackBarLength: Int = Snackbar.LENGTH_SHORT
        var snackBar : Snackbar? = null

        init {
            snackBar = Snackbar.make(snackBarView,snackBarMessage,snackBarLength)
        }

        fun setDuration(snackBarLength: Int) : Builder {
            snackBar?.duration = snackBarLength
            return this
        }

        fun setMessage(snackBarLength: Int) : Builder {
            snackBar?.duration = snackBarLength
            return this
        }

        fun show() : Builder {
            snackBar?.show()
            return this
        }

        fun setActionById(id: Int,listener: (View)-> Unit) {
            snackBar?.setAction(id, listener)
        }

        fun setActionByName(name: String,listener: (View)-> Unit) {
            snackBar?.setAction(name, listener)
        }


        fun create(): SnackBarCustom {
            return SnackBarCustom(this)
        }

    }



}