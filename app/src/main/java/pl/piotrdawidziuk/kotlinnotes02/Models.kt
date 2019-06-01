package pl.piotrdawidziuk.kotlinnotes02

class Task(
    private var title: String,
    private var todos: List<Todo>?,
    private var tag: Tag?
)
class Todo (
    private var description: String,
    private var isComplete: Boolean
)
class Tag (
    private var name:String,
    private var colorResId: Int
)