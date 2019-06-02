package pl.piotrdawidziuk.kotlinnotes02.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_task.view.*
import pl.piotrdawidziuk.kotlinnotes02.R
import pl.piotrdawidziuk.kotlinnotes02.models.Task

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Task

    fun initView (task: Task) {
        this.task = task

        titleView.text = task.title
        task.todos.forEach{todo ->

            val todoView = (LayoutInflater.from(context).inflate(R.layout.view_todo, todoContainer,false)as TodoView).apply {
                initView(todo){
                    if(isTaskComplete()){
                        createStrikeThru()
                    }else{
                        removeStrikeThru()
                    }
                }
            }
            todoContainer.addView(todoView)
        }
    }

    fun isTaskComplete(): Boolean = task.todos.filter {!it.isComplete}.isEmpty()

    private fun createStrikeThru() {

        titleView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThru() {

        titleView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

}