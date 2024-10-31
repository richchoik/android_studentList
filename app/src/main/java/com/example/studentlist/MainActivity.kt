package com.example.studentlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studentlist.ui.theme.StudentListTheme
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView

class MainActivity : ComponentActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var fullStudentList: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEditText: EditText = findViewById(R.id.searchEditText)
        val listView: ListView = findViewById(R.id.listView)

        fullStudentList = listOf(
            Student("Phan Doãn Thuấn", "20210822"),
            Student("Hoàng Quang Tùng", "20210916"),
            Student("Trịnh Hà Trung", "20211212"),
            Student("Trịnh Hà Lâm", "20221313"),
            Student("Hoàng Thị Trang", "20221414")
        )

        studentAdapter = StudentAdapter(this, fullStudentList)
        listView.adapter = studentAdapter

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString()
                if (query.length > 2) {
                    val filteredList = fullStudentList.filter {
                        it.name.contains(query, ignoreCase = true) || it.studentId.contains(query, ignoreCase = true)
                    }
                    studentAdapter.updateList(filteredList)
                } else {
                    studentAdapter.updateList(fullStudentList)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
