package com.mipa.learnandroidfundamentals

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.mipa.learnandroidfundamentals.RecView.RecView
import com.mipa.learnandroidfundamentals.bottom_navigation_menu.BottomNavMenu
import com.mipa.learnandroidfundamentals.broadcast.Broadcast
import com.mipa.learnandroidfundamentals.drag_drop.DragDrop
import com.mipa.learnandroidfundamentals.fragments.Fragments
import com.mipa.learnandroidfundamentals.coroutines.CoroutinesMain
import com.mipa.learnandroidfundamentals.manual_creation.UIFromCode
import com.mipa.learnandroidfundamentals.services.intent_service.LrnIntentService
import com.mipa.learnandroidfundamentals.notifications.Notification
import com.mipa.learnandroidfundamentals.services.LrnService
import com.mipa.learnandroidfundamentals.shared_preferences.SaveData
import com.mipa.learnandroidfundamentals.slidable_menu.SlidableMenu
import com.mipa.learnandroidfundamentals.view_pager.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBtnListeners()
        this.title = "kek"
        if (actionBar != null) {
            actionBar!!.title = "My Menu"
            actionBar!!.subtitle = "My Subtitle"
        }
    }

    fun initBtnListeners(){
        btnApply.setOnClickListener() {
            val name = etName.text.toString()
            val age = etAge.text.toString().let {
                if (it.isBlank()) {
                    "0"
                } else it
            }.toInt()
            val country = etCountry.text.toString()
            val person = Person(name, age, country)

            Intent(this, SecondActivity::class.java).also {
//                it.putExtra("EXTRA_NAME", name)
//                it.putExtra("EXTRA_AGE", age)
//                it.putExtra("EXTRA_COUNTRY", country)
                it.putExtra("EXTRA_PERSON", person)
                startActivity(it)
            }
        }

        btnRequest.setOnClickListener() {
            requestPermissions()
        }

        btnImplIntent.setOnClickListener {
            Intent(this, ImplicitIntents::class.java).also {
                startActivity(it)
            }
        }

        btnAlerts.setOnClickListener {
            Intent(this, Alerts::class.java).also {
                startActivity(it)
            }
        }

        btnSpinner.setOnClickListener {
            Intent(this, Spinner::class.java).also {
                startActivity(it)
            }
        }

        btnRecView.setOnClickListener {
            Intent(this, RecView::class.java).also {
                startActivity(it)
            }
        }

        btnFragments.setOnClickListener {
            Intent(this, Fragments::class.java).also {
                startActivity(it)
            }
        }

        btnBotNavMenu.setOnClickListener {
            Intent(this, BottomNavMenu::class.java).also {
                startActivity(it)
            }
        }
        btnViewPager.setOnClickListener {
            Intent(this, ViewPager::class.java).also {
                startActivity(it)
            }
        }
        slidableMenu.setOnClickListener {
            Intent(this, SlidableMenu::class.java).also {
                startActivity(it)
            }
        }

        saveData.setOnClickListener {
            Intent(this, SaveData::class.java).also {
                startActivity(it)
            }
        }

        notify.setOnClickListener {
            Intent(this, Notification::class.java).also {
                startActivity(it)
            }
        }

        intentService.setOnClickListener {
            Intent(this, LrnIntentService::class.java).also {
                startActivity(it)
            }
        }

        service.setOnClickListener {
            Intent(this, LrnService::class.java).also {
                startActivity(it)
            }
        }

        dragDrop.setOnClickListener {
            Intent(this, DragDrop::class.java).also {
                startActivity(it)
            }
        }
//
//        broadcast.setOnClickListener {
//            Intent(this, Broadcast::class.java).also {
//                startActivity(it)
//            }
//        }

        broadcast.setOnClickListener {
            Intent(this, UIFromCode::class.java).also {
                startActivity(it)
            }
        }

        coroutine.setOnClickListener {
            Intent(this, CoroutinesMain::class.java).also {
                startActivity(it)
            }
        }
    }



    //Menu bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miAddContact -> Toast.makeText(this, "Add contact", Toast.LENGTH_SHORT).show()
            R.id.miFavorites -> Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show()
            R.id.miFeedback -> Toast.makeText(this, "Feedback", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            R.id.miClose -> {
                Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        return true
    }


    // permissions
    private fun hasWriteExternalPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForegroundPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationBackgroundPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    private fun requestPermissions() {
        var permissionsToRequest = mutableListOf<String>()
        if (!hasWriteExternalPermission()) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasLocationForegroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if (!hasLocationBackgroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        if (permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("MainActivity perm request", "${permissions[i]} granted")
                }
            }
        }
    }
}