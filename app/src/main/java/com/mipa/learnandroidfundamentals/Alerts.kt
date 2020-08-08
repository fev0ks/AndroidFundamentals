package com.mipa.learnandroidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_alerts.*

class Alerts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add Far to your contacts list?")
            .setIcon(R.drawable.ic_add_contact_foreground)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You added Far to your contact list", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You didn't add Far to your contact list", Toast.LENGTH_SHORT)
                    .show()
            }
            .create()

        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("First", "Second", "Third")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of options")
            .setSingleChoiceItems(options, 0) { dialigInterface, i ->
                Toast.makeText(this, "You clicked in ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined the SingleChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }
            .create()

        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multipleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined the SingleChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }
            .create()

        btnDialog3.setOnClickListener {
            multipleChoiceDialog.show()
        }

    }
}