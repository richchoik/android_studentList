package com.example.studentlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class StudentAdapter(private val context: Context, private var studentList: List<Student>) : BaseAdapter() {

    override fun getCount(): Int = studentList.size

    override fun getItem(position: Int): Any = studentList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.student_item, parent, false)
        val student = studentList[position]

        val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        val studentIdTextView = view.findViewById<TextView>(R.id.studentIdTextView)

        nameTextView.text = student.name
        studentIdTextView.text = student.studentId

        return view
    }

    fun updateList(newList: List<Student>) {
        studentList = newList
        notifyDataSetChanged()
    }
}
