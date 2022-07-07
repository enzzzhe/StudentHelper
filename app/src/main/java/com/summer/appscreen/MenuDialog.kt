package com.summer.appscreen

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.fragment.app.DialogFragment

class MenuDialog: DialogFragment() {
    private val actions = arrayOf("Редактировать","Удалить","Отмена")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setItems(actions){
                //dialog, which -> Toast.makeText(activity, "${actions[which]}", Toast.LENGTH_SHORT).show()
                dialog, item -> if (actions[item] == "Редактировать"){

                }else if (actions[item] == "Удалить"){

                }else if (actions[item] == "Отмена"){
                    dialog.cancel()
                }
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}