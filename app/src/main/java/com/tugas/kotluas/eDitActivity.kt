package com.tugas.kotluas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class eDitActivity : AppCompatActivity() {
    private lateinit var txjudul: TextInputEditText
    private lateinit var txauthor: TextInputEditText
    private lateinit var txtahun: TextInputEditText
    private lateinit var btnEdit: AppCompatButton
    private val api by lazy { Connetor().endpoint }
    private val idB by lazy {intent.getSerializableExtra("id_buku")as Netmodel.Buku}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        supportActionBar!!.title="UPDATE DATA BUKU"

        setupVw()
        setupListnr()
    }
    private fun setupVw(){
        txjudul = findViewById(R.id.judeditx)
        txauthor = findViewById(R.id.penuleditx)
        txtahun = findViewById(R.id.thneditx)
        btnEdit = findViewById(R.id.ediData)

        txjudul.setText(idB.judulBuku)
        txauthor.setText(idB.penulis)
        txtahun.setText(idB.tahunTerbit)
    }
    private fun setupListnr(){
btnEdit.setOnClickListener {
   api.update(idB.idBuku!!,
       txjudul.text.toString(),
        txauthor.text.toString(),
       txtahun.text.toString() )
        .enqueue(object : Callback<SumbitMOdel> {
            override fun onResponse(
                call: Call<SumbitMOdel>,
                response: Response<SumbitMOdel>
            ) {
                if(response.isSuccessful){
                    val ubah=response.body()
                    Toast.makeText(
                        applicationContext,
                        ubah!!.message
                        , Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
}

            override fun onFailure(call: Call<SumbitMOdel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
}
    }
}