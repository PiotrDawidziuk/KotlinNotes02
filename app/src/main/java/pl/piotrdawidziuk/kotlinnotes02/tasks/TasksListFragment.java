package pl.piotrdawidziuk.kotlinnotes02.tasks;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.piotrdawidziuk.kotlinnotes02.R;

public class TasksListFragment extends Fragment {

    public TasksListFragment() {
    }

    public static TasksListFragment newInstance() {
        TasksListFragment fragment = new TasksListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_list, container, false);
    }

}
