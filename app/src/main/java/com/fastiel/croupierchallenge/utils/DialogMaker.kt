package com.fastiel.croupierchallenge.utils

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog

object DialogMaker {

    fun showDialog(context: Context?, title:String, message:String, acceptButtonText:String){
        val context = context ?: return
        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL, acceptButtonText,
            DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
        alertDialog.show()
    }
}