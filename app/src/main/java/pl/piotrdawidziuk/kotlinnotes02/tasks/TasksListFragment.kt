package pl.piotrdawidziuk.kotlinnotes02.tasks


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tasks_list.*
import pl.piotrdawidziuk.kotlinnotes02.R

class TasksListFragment : Fragment() {

    lateinit var viewModel: TaskViewModel
    lateinit var touchActionDelegate: TouchActionDelegate

    lateinit var adapter: TaskAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            if (it is TouchActionDelegate){
                touchActionDelegate = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
         adapter = TaskAdapter(
            touchActionDelegate = touchActionDelegate
        )
        recyclerView.adapter = adapter

        bindViewModel()
    }

    private fun bindViewModel(){
        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)

        viewModel.taskListLiveData.observe(this, Observer{taskList ->

            adapter.updateList(taskList)

        })

    }

    companion object {
        fun newInstance() = TasksListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }

}
