package com.tugas.kotluas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    private lateinit var lgemail: TextInputEditText
    private lateinit var lgsandi: TextInputEditText
    private lateinit var lgbutton: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        lgemail = findViewById(R.id.etmail)
        lgsandi = findViewById(R.id.etpass)
        lgbutton = findViewById(R.id.btnlogin)
        lgbutton.setOnClickListener(View.OnClickListener {
//            if (lgemail.getText().toString().equals("lord.jav@jav-hihi.gov") && lgsandi.getText()
//                    .toString().equals("yamete")
//            ) {
//                //jka benar
////                val suskselogin = Intent(this@LoginActivity,MainActivity::class.java)
////                startActivity(suskselogin)
                startActivity(
                    Intent(this@LoginActivity,MainActivity::class.java))
//            } else {
//                //jika salah
//                Toast.makeText(this, "Email / Password tidak benar", Toast.LENGTH_SHORT)
//                    .show()
//            }
        })
    }
}