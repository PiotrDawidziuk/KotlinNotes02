package pl.piotrdawidziuk.kotlinnotes02.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.piotrdawidziuk.kotlinnotes02.models.Note

class NoteViewModel: ViewModel(){

    private val _noteListLiveDate: MutableLiveData<List<Note>> = MutableLiveData()
    val noteListLiveData: LiveData<List<Note>> = _noteListLiveDate

    init {
        _noteListLiveDate.postValue(getFakeData())
    }

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Some note number 1"),
        Note("Some note number 2")
    )


}