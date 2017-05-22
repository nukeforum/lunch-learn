package com.rook.lunchandlearn

import android.app.Activity
import android.app.Dialog
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Rook on 5/21/2017.
 */


fun View.snackbar(text: CharSequence, duration: Int = Snackbar.LENGTH_SHORT, init: Snackbar.() -> Unit = {}): Snackbar {
    val snack = Snackbar.make(this, text, duration)
    snack.init()
    snack.show()
    return snack
}

fun Activity.dialog(layoutId: Int, init: Dialog.() -> Unit = {}): Dialog {
    val dialog = Dialog(this)
    dialog.setContentView(layoutId)
    dialog.init()
    return dialog
}

fun ViewGroup.inflate(layoutId: Int) = LayoutInflater.from(context).inflate(layoutId, this, false)