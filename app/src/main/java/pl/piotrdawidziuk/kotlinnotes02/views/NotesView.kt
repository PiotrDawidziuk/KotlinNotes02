package pl.piotrdawidziuk.kotlinnotes02.views

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_note.view.*
import pl.piotrdawidziuk.kotlinnotes02.models.Note

class NotesView @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1

) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView (note: Note){
        descriptionView.text = note.description
    }

}