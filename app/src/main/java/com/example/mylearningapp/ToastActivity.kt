package com.example.mylearningapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylearningapp.databinding.ActivityToastBinding
import com.google.android.material.snackbar.Snackbar

class ToastActivity : AppCompatActivity() {
    lateinit var toastBinding: ActivityToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        toastBinding = ActivityToastBinding.inflate(layoutInflater)
        val view =  toastBinding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.toast_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        toastBinding.toastButton.setOnClickListener {
            Toast.makeText(this, "This is a toast message example", Toast.LENGTH_SHORT).show()
        }

        toastBinding.snackButton.setOnClickListener {
            Snackbar.make(
                toastBinding.toastLayout,
                "This is a snack bar message example",
                Snackbar.LENGTH_SHORT
            )
                .setAction("Close") {}.show()
        }

        toastBinding.dialogButton.setOnClickListener {
            showAlertDialog()
        }

        toastBinding.button4.setOnClickListener {
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
            toastBinding.dialogButton.text = getString(R.string.alert_dialog)
        }

        alertDialog.create().show()
    }
}