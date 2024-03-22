package com.bangkit23dwinovirhmwt.daftarbuku

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = supportActionBar
        actionBar!!.title = "Detail Buku"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvDetailTitle = findViewById<TextView>(R.id.tv_detail_title)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)
        val tvDetailRelease = findViewById<TextView>(R.id.tv_detail_release)
        val tvDetailPublisher = findViewById<TextView>(R.id.tv_detail_publisher)

        val dataBook = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_book", Book::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_book")
        }

        if (dataBook != null) {
            tvDetailTitle.text = dataBook.name
            tvDetailDescription.text = dataBook.description
            dataBook.let { ivDetailPhoto.setImageResource(it.book) }
            tvDetailRelease.text = dataBook.release
            tvDetailPublisher.text = dataBook.publisher
        } else {
            Log.e("DetailActivity", "dataBook is null")
            // Handle the case where dataBook is null (e.g., show an error message).
        }
    }

    //Coba buat intent implisit
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }

            R.id.action_share -> {

                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "*/*"
                intent.`package` = "com.android.bluetooth" // Package name untuk aplikasi Bluetooth
                intent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Teks yang ingin Anda bagikan melalui Bluetooth"
                ) // Teks yang ingin dibagikan

                startActivity(Intent.createChooser(intent, "Bagikan melalui Bluetooth"))
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}