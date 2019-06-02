package pl.piotrdawidziuk.kotlinnotes02.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet

import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.view_todo.view.*
import pl.piotrdawidziuk.kotlinnotes02.models.Todo

class TodoView @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1

) : ConstraintLayout (context, attrs, defStyleAttr) {

    fun initView(todo: Todo) {

        descriptionTextView.text = todo.description
        completeCheckBox.isChecked = todo.isComplete

        if (todo.isComplete) {
            createStrikeThru()
        }

        setUpCheckStateListener()

    }

   private fun setUpCheckStateListener() {
        completeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                createStrikeThru()
            } else {
                removeStrikeThru()
            }
        }
    }

    private fun createStrikeThru() {

        descriptionTextView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThru() {

        descriptionTextView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}
