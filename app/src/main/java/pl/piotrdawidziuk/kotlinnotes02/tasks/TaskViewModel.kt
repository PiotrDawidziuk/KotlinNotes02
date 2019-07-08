package pl.piotrdawidziuk.kotlinnotes02.tasks

import androidx.lifecycle.ViewModel
import pl.piotrdawidziuk.kotlinnotes02.models.Task
import pl.piotrdawidziuk.kotlinnotes02.models.Todo

class TaskViewModel : ViewModel() {

    fun getFakeData(): List<Task> = mutableListOf(
        Task("Testing 1", mutableListOf(
            Todo("Test One!",true),
            Todo("Test Two!")
        )),
        Task("Testing 2", mutableListOf(
            Todo("Test Three!"),
            Todo("Test Four!",true)
        )),
        Task("Task3", mutableListOf(
            Todo("Test four"),
            Todo ("test five",true))
    ))
    

}