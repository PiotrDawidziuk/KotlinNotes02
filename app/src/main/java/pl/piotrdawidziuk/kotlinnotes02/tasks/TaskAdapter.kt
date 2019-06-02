package pl.piotrdawidziuk.kotlinnotes02.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_add_button.view.*
import pl.piotrdawidziuk.kotlinnotes02.R
import pl.piotrdawidziuk.kotlinnotes02.foundations.BaseRecyclerAdapter
import pl.piotrdawidziuk.kotlinnotes02.models.Task
import pl.piotrdawidziuk.kotlinnotes02.views.TaskView

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf()

): BaseRecyclerAdapter<Task>(taskList) {

    override fun getItemViewType(position: Int): Int = if (position==0){
        TYPE_AND_BUTTON
    } else { TYPE_INFO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if(viewType == TYPE_INFO){
        TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false))
    }else{
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button,parent,false))
    }

    override fun getItemCount(): Int = masterList.size + 1


    class TaskViewHolder (view: View): BaseViewHolder<Task>(view){
        override fun onBind(data: Task) {
            (view as TaskView).initView(data)
        }
    }

    class AddButtonViewHolder (view: View): BaseViewHolder<Unit>(view){
        override fun onBind(data: Unit) {
            view.buttonText.text =
        }
    }

    companion object {
        const val TYPE_AND_BUTTON =0
        const val TYPE_INFO = 1
    }

}