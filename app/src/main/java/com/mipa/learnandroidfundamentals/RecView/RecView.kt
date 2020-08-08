package com.mipa.learnandroidfundamentals.RecView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_rec_view.*
import kotlinx.android.synthetic.main.item_todo.*
import kotlinx.android.synthetic.main.item_todo.view.*

class RecView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rec_view)

        val todosList = mutableListOf(
            Todo("Follow androidDevs", false),
            Todo("qwe1", false),
            Todo("qwe2", true),
            Todo("qwe3", false),
            Todo("qwe4", false),
            Todo("qwe5", true),
            Todo("qwe6", false),
            Todo("qwe7", false),
            Todo("qwe8", true)
        )

        val adapter = TodoAdapter(todosList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val title = edTodo.text.toString()
            val todo = Todo(title, false)
            (rvTodos.adapter as TodoAdapter).todos.add(todo)
            adapter.notifyDataSetChanged()
//            adapter.notifyItemInserted(todosList.size - 1)
        }


    }
}