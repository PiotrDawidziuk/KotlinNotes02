package pl.piotrdawidziuk.kotlinnotes02.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create.*
import pl.piotrdawidziuk.kotlinnotes02.R
import pl.piotrdawidziuk.kotlinnotes02.navigation.NavigationActivity

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY).run {
            testTextView.text = if (this == NavigationActivity.FRAGMENT_VALUE_IS_TASK){
                "this is a task"
            } else if (this == NavigationActivity.FRAGMENT_VALUE_IS_NOTE){
                "this is a note"
            } else {
                "something went wrong"
            }
        }

    }
}
