package pl.piotrdawidziuk.kotlinnotes02.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*
import kotlinx.android.synthetic.main.item_task.view.*
import pl.piotrdawidziuk.kotlinnotes02.R
import pl.piotrdawidziuk.kotlinnotes02.foundations.BaseRecyclerAdapter
import pl.piotrdawidziuk.kotlinnotes02.models.Note
import pl.piotrdawidziuk.kotlinnotes02.models.Task
import pl.piotrdawidziuk.kotlinnotes02.views.NotesView

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf()

): BaseRecyclerAdapter<Note>(noteList){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder  =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false))

    class ViewHolder (view: View): BaseViewHolder<Note>(view){
        override fun onBind(data: Note) {
            (view as NotesView).initView(data)
        }
    }
}