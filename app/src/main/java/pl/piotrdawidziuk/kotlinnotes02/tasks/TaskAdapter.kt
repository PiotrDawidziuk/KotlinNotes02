package pl.piotrdawidziuk.kotlinnotes02.tasks

import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_add_button.view.*
import pl.piotrdawidziuk.kotlinnotes02.R
import pl.piotrdawidziuk.kotlinnotes02.foundations.BaseRecyclerAdapter
import pl.piotrdawidziuk.kotlinnotes02.models.Task
import pl.piotrdawidziuk.kotlinnotes02.navigation.NavigationActivity
import pl.piotrdawidziuk.kotlinnotes02.views.TaskView

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf(),
    val touchActionDelegate: TasksListFragment.TouchActionDelegate
    ): BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if(viewType == TYPE_INFO){
        TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false))
    }else{
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button,parent,false))
    }

    class TaskViewHolder (view: View): BaseViewHolder<Task>(view){
        override fun onBind(data: Task) {
            (view as TaskView).initView(data)
        }
    }

    inner class AddButtonViewHolder (view: View): BaseRecyclerAdapter.AddButtonViewHolder(view){
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_task)

            view.setOnClickListener{
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_IS_TASK)
            }

        }
    }

}