package pl.piotrdawidziuk.kotlinnotes02.models

data class Task @JvmOverloads constructor(
    var title: String,
    var todos: MutableList<Todo> = mutableListOf(),
    var tag: Tag? = null
)
data class Todo (
    var description: String,
    var isComplete: Boolean = false
)
data class Tag (
    var name:String,
    var colorResId: Int
)
data class Note (
    val description: String,
    val tag: Tag? = null
)