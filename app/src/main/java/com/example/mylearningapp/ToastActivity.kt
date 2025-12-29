package com.example.mylearningapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class ToastActivity : AppCompatActivity() {

    lateinit var toastButton: Button
    lateinit var home: Button
    lateinit var snack: Button
    lateinit var toastLayout: LinearLayout
    lateinit var dialog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_toast)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.toast_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toastButton = findViewById(R.id.toast_button)
        snack = findViewById(R.id.snack_button)
        home = findViewById(R.id.button4)
        toastLayout = findViewById(R.id.toast_layout)
        dialog = findViewById(R.id.dialog_button)



        toastButton.setOnClickListener {
            Toast.makeText(this, "This is a toast message example", Toast.LENGTH_SHORT).show()
        }

        snack.setOnClickListener {
            Snackbar.make(
                toastLayout,
                "This is a snack bar message example",
                Snackbar.LENGTH_SHORT
            )
                .setAction("Close") {}.show()
        }

        dialog.setOnClickListener {
            showAlertDialog()
        }

        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Change")
        alertDialog.setMessage("Do you wish to continue changing the text on the button?")
        alertDialog.setIcon(R.drawable.warning)
        alertDialog.setCancelable(false)

        alertDialog.setNegativeButton("No") { dialogInterface, _ ->
            dialogInterface.cancel()
        }

        alertDialog.setPositiveButton("Yes") { _, _ ->
            dialog.text = getString(R.string.alert_dialog)
        }

        alertDialog.create().show()
    }
}