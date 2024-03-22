package com.bangkit23dwinovirhmwt.daftarbuku

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBooks: RecyclerView
    private val list = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Daftar Buku"

        rvBooks = findViewById(R.id.rv_book)
        rvBooks.setHasFixedSize(true)

        list.addAll(getListBook())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("Recycle")
    private fun getListBook(): ArrayList<Book> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_book)
        val dataPublisher = resources.getStringArray(R.array.data_publisher)
        val dataRelease = resources.getStringArray(R.array.data_release)

        val listBook = ArrayList<Book>()

        for (i in dataTitle.indices) {
            val book = Book(
                dataTitle[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1),
                dataPublisher[i],
                dataRelease[i]
            )
            listBook.add(book)
        }
        return listBook
    }

    private fun showRecyclerList() {
        rvBooks.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(list)
        rvBooks.adapter = listBookAdapter
    }
}