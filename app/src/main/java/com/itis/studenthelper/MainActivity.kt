package com.itis.studenthelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var checkBox: CheckBox
    lateinit var percentOfPlan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countPercent()
    }

    fun countPercent(){
        var count = 0
        var percent = 0
        checkBox = findViewById(R.id.checkBox)
        percentOfPlan = findViewById(R.id.tv_percent)

        if (checkBox.isChecked){
            count += 1
        }
        percent = 100 * count / TaskRepository.tasks.size
        percentOfPlan.append("Выполнено $percent% плана")
    }

    fun addTask(view: View) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.add_task, null)
        val editText  = dialogLayout.findViewById<EditText>(R.id.et_add)
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") { dialogInterface, i -> dialogInterface }
        builder.setNegativeButton("Отмена") { dialogInterface, i -> dialogInterface }
        builder.show()
    }

    fun operations(view: View) {

        val items = arrayOf("Редактировать", "Удалить", "Отмена")
        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            setItems(items) { dialog, which -> items[0]}
            show()
        }
    }
}