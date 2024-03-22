package com.bangkit23dwinovirhmwt.daftarbuku

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val actionBar = supportActionBar
        actionBar!!.title = "About"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)

        nameTextView.text = "Dwi Novi Rahmawati"
        emailTextView.text = "dwinovirhmwt@gmail.com"
    }

}
