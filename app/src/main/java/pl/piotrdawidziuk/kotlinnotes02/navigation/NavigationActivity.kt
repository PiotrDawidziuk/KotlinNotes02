package pl.piotrdawidziuk.kotlinnotes02.navigation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_navigation.*
import pl.piotrdawidziuk.kotlinnotes02.R

class NavigationActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_tasks -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notes -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }

}
