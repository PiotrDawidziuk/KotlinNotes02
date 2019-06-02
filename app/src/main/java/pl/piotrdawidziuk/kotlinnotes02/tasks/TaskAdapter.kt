package pl.piotrdawidziuk.kotlinnotes02.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*
import pl.piotrdawidziuk.kotlinnotes02.R
import pl.piotrdawidziuk.kotlinnotes02.foundations.BaseRecyclerAdapter
import pl.piotrdawidziuk.kotlinnotes02.models.Task

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf()

): BaseRecyclerAdapter<Task>(taskList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false))

    class ViewHolder (view: View): BaseViewHolder<Task>(view){
        override fun onBind(data: Task) {
            view.titleView.text = data.title
        }
    }

}