package pl.piotrdawidziuk.kotlinnotes02.notes

import androidx.lifecycle.ViewModel
import pl.piotrdawidziuk.kotlinnotes02.models.Note

class NoteViewModel: ViewModel(){

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Some note number 1"),
        Note("Some note number 2")
    )
    

}