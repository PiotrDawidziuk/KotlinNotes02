package pl.piotrdawidziuk.kotlinnotes02.notes


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tasks_list.*

import pl.piotrdawidziuk.kotlinnotes02.R
import pl.piotrdawidziuk.kotlinnotes02.models.Note
import pl.piotrdawidziuk.kotlinnotes02.tasks.TasksListFragment

class NotesListFragment : Fragment() {

    lateinit var touchActionDelegate: NotesListFragment.TouchActionDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            if (it is NotesListFragment.TouchActionDelegate){
                touchActionDelegate = it
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = NoteAdapter(mutableListOf(
            Note("Some note number 1"),
            Note("Some note number 2")
        ),
            touchActionDelegate
        )
        recyclerView.adapter = adapter
    }

    companion object {

        fun newInstance() = NotesListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }


}
