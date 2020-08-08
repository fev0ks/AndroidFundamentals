package com.mipa.learnandroidfundamentals.RecView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_second.view.*
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter(
    var todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text = todos[position].title
            cbDone.isChecked = todos[position].isChecked

        }
    }

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }


}