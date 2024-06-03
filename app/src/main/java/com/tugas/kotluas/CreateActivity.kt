package com.tugas.kotluas

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateActivity : AppCompatActivity() {
    private lateinit var txjudul: TextInputEditText
    private lateinit var txauthor: TextInputEditText
    private lateinit var txtahun: TextInputEditText
    private lateinit var btnsubmit: AppCompatButton
    private val api by lazy { Connetor().endpoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        supportActionBar!!.title="TAMBAH DATA BUKU"

        setupV()
        setupListr()
    }

    private fun setupV() {
        // Tambahan konfigurasi UI atau logika lainnya dapat ditempatkan di sini jika diperlukan

        txjudul = findViewById(R.id.jdbook)
        txauthor = findViewById(R.id.penulis)
        txtahun = findViewById(R.id.thnTerbit)
        btnsubmit = findViewById(R.id.simpanData)
    }

    private fun setupListr() {
        btnsubmit.setOnClickListener {
            if (txjudul.text.toString().isNotEmpty()&&txauthor.text.toString().isNotEmpty()&&txtahun.text.toString().isNotEmpty()) {
                Log.e("CreateActivity", txjudul.text.toString(),
                )
                api.simpan(
                    txjudul.text.toString(),
                    txauthor.text.toString(),
                    txtahun.text.toString())
                    .enqueue(object :Callback<SumbitMOdel>{
                        override fun onResponse(
                            call: Call<SumbitMOdel>,
                            response: Response<SumbitMOdel>
                        ) {
                           if(response.isSuccessful){
                               val submit=response.body()
                               Toast.makeText(
                                   applicationContext,
                                   submit!!.message
                               ,Toast.LENGTH_SHORT
                               ).show()
                               finish()
                            }
                        }

                        override fun onFailure(call: Call<SumbitMOdel>, t: Throwable) {
                            TODO("Not yet implemented")
                        }
                    })
            } else {
                Toast.makeText(
                    this@CreateActivity, // tambahkan context (this) sebagai parameter pertama
                    "Isian harus diisi!", // pesan yang akan ditampilkan
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
