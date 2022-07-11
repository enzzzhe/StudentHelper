package com.itis.studenthelper
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.itis.studenthelper.databinding.FragmentScheduleBinding
import java.util.*

class ScheduleFragment : Fragment(R.layout.fragment_schedule){
    private var _binding : FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    private var buttonAdd: ImageButton? = null
    private var adapter: TaskForDayAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentScheduleBinding.bind(view)
        initAdapter()
        binding.rvTask.adapter = adapter

        buttonAdd = view.findViewById(R.id.add_task_button)
        buttonAdd?.setOnClickListener{
            var calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(requireContext(),  { view, newYear, newMonth, newDayOfMonth ->
                calendar.set(Calendar.YEAR,newYear)
                calendar.set(Calendar.MONTH,newMonth)
                calendar.set(Calendar.DAY_OF_MONTH,newDayOfMonth)
                showAddTaskDialog(it,calendar)

            }, year, month, day)
            datePickerDialog.show()
        }

    }

    fun showAddTaskDialog(v: View,calendar: Calendar) {

        val builder = AlertDialog.Builder(requireContext()).create()
        val view = layoutInflater.inflate(R.layout.dialog_add_task,null)
        builder.setView(view)

        val  buttonTo = view.findViewById<Button>(R.id.from_button)
        val  buttonFrom = view.findViewById<Button>(R.id.to_button)
        val  inputText = view.findViewById<EditText>(R.id.input_task)
        val  buttonOk = view.findViewById<Button>(R.id.ok_btn)
        val  buttonCancel = view.findViewById<Button>(R.id.cancel_btn)

        var calendarFrom = Calendar.getInstance()
        var calendarTo = Calendar.getInstance()


        buttonTo.setOnClickListener {
            calendarFrom = showTimePickerDialog(it)
            calendarFrom.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE))
        }
        buttonFrom.setOnClickListener {
            calendarTo = showTimePickerDialog(it)
            calendarTo.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE))
        }
        buttonOk.setOnClickListener {
            TaskForDayRepository.addTask(TaskForDay(TaskForDayRepository.actualId,inputText.text.toString(),calendarFrom,calendarTo))
            TaskForDayRepository.actualId++
            adapter?.updateData(TaskForDayRepository.taskArray)
            builder.dismiss()

        }
        buttonCancel.setOnClickListener {
            builder.dismiss()
        }

        builder.setCanceledOnTouchOutside(false)
        builder.show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(){
        adapter = TaskForDayAdapter(TaskForDayRepository.taskArray)

    }
    fun showTimePickerDialog(v: View):Calendar {
        var calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(requireContext(), { view, newHour, newMinute ->
            calendar.set(Calendar.HOUR, newHour)
            calendar.set(Calendar.MINUTE, newMinute)
        }, hour, minute, true)
        timePickerDialog.show()
        return calendar
    }
}