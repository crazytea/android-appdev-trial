package com.yellow.tp_zoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.viewModels
import com.yellow.tp_zoo.DataModel.DataZooInfo
import com.yellow.tp_zoo.ui.dashboard.DashboardFragment

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val dataZooitem = intent.getParcelableExtra<DataZooInfo>("data")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var fragment: DashboardFragment = supportFragmentManager.findFragmentById(R.id.fragment_zoo_info) as DashboardFragment
        fragment.update_data(dataZooitem)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}