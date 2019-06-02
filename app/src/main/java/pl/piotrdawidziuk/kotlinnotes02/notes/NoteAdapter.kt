package pl.piotrdawidziuk.kotlinnotes02.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_add_button.view.*
import pl.piotrdawidziuk.kotlinnotes02.R
import pl.piotrdawidziuk.kotlinnotes02.foundations.BaseRecyclerAdapter
import pl.piotrdawidziuk.kotlinnotes02.models.Note
import pl.piotrdawidziuk.kotlinnotes02.navigation.NavigationActivity
import pl.piotrdawidziuk.kotlinnotes02.views.NotesView

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf(),
    val touchActionDelegate: NotesListFragment.TouchActionDelegate
): BaseRecyclerAdapter<Note>(noteList){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder  = if(viewType == TYPE_AND_BUTTON){
     AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button,parent,false))
    }else {
        NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
    }
    class NoteViewHolder (view: View): BaseViewHolder<Note>(view){
        override fun onBind(data: Note) {
            (view as NotesView).initView(data)
        }
    }

    inner class AddButtonViewHolder (view: View): BaseRecyclerAdapter.AddButtonViewHolder(view){
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)

            view.setOnClickListener{
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_IS_NOTE)
            }
        }
    }
}