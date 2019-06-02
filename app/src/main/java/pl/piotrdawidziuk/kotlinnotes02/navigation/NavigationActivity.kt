package pl.piotrdawidziuk.kotlinnotes02.navigation

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_navigation.*
import pl.piotrdawidziuk.kotlinnotes02.R
import pl.piotrdawidziuk.kotlinnotes02.create.CreateActivity
import pl.piotrdawidziuk.kotlinnotes02.notes.NotesListFragment
import pl.piotrdawidziuk.kotlinnotes02.tasks.TasksListFragment

class NavigationActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_tasks -> {
                replaceFragment(TasksListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notes -> {
                replaceFragment(NotesListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        replaceFragment(TasksListFragment.newInstance())

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun goToCreateActivity(){
        startActivity(Intent(this,CreateActivity::class.java))
    }

    private fun replaceFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHolder,fragment)
            .commit()
    }

}
