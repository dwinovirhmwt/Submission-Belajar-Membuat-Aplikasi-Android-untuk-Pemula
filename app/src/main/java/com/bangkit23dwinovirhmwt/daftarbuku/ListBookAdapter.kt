package com.bangkit23dwinovirhmwt.daftarbuku

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListBookAdapter(private val listBook: ArrayList<Book>) :
    RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_book, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, book) = listBook[position]
        holder.imgPhoto.setImageResource(book)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Buku yang dipilih " + listBook[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_book", listBook[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listBook.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_book)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}