package com.tugas.kotluas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapterx  (
    val bukubuk:ArrayList<Netmodel.Buku>,
    val listener: OnAdapterListenr
        ):RecyclerView.Adapter<Adapterx.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=ViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adaptor_note,parent,false)
    )

    override fun onBindViewHolder(holder: Adapterx.ViewHolder, position: Int) {
        val dataa=bukubuk[position]
        holder.jubuktxv.text=dataa.judulBuku
        holder.penultxv.text=dataa.penulis
        holder.thntxv.text=dataa.tahunTerbit
        holder.itemView.setOnClickListener{
            listener.onUpdate(dataa)
        }
        holder.ImgDel.setOnClickListener{
            listener.onDeldel(dataa)
        }
    }

    override fun getItemCount()=bukubuk.size

class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
val jubuktxv=view.findViewById<TextView>(R.id.judulbook)
    val penultxv=view.findViewById<TextView>(R.id.penulisid)
    val thntxv=view.findViewById<TextView>(R.id.thntrbit)
    val ImgDel=view.findViewById<ImageView>(R.id.delbook)
}
    public fun setDat(buku: List<Netmodel.Buku>){
        bukubuk.clear()
        bukubuk.addAll(buku)
        notifyDataSetChanged()
    }
    interface OnAdapterListenr{
        fun onUpdate(buku: Netmodel.Buku)
        fun onDeldel(buku: Netmodel.Buku)
    }
}