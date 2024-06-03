package com.tugas.kotluas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api by lazy { Connetor().endpoint }
    private lateinit var adapterx: Adapterx
    private lateinit var listNote: RecyclerView
    private lateinit var fabCreate: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title="DAFTAR BUKU"
        setupView()
    setupList()
        setListenier()
                    }
    private fun setupView(){
        listNote =findViewById(R.id.listnote)
        fabCreate=findViewById(R.id.submitbtn)

    }
    override fun onStart(){
        super.onStart()
        getBook()
    }
    private fun setupList(){
        adapterx = Adapterx(arrayListOf(), object : Adapterx.OnAdapterListenr {
            override fun onUpdate(buku: Netmodel.Buku) {
                startActivity(
                    Intent(this@MainActivity,eDitActivity::class.java)
                        .putExtra("id_buku",buku)
                )
            }

            override fun onDeldel(buku: Netmodel.Buku) {
                api.hapus(buku.idBuku!!).enqueue(object : Callback<SumbitMOdel>{
                    override fun onResponse(
                        call: Call<SumbitMOdel>,
                        response: Response<SumbitMOdel>
                    ) {
                        if(response.isSuccessful){
                            val submit=response.body()
                            Toast.makeText(
                                applicationContext,
                                submit!!.message
                                , Toast.LENGTH_SHORT
                            ).show()
                            getBook()
                        }
                    }

                    override fun onFailure(call: Call<SumbitMOdel>, t: Throwable) {

                    }

                } )
            }

        })
        listNote.adapter = adapterx
    }
    private fun setListenier(){
        fabCreate.setOnClickListener{
            startActivity(Intent(this,CreateActivity::class.java))
        }
    }
    private fun getBook(){
        api.tampildata().enqueue(object :retrofit2.Callback<Netmodel>{
            override fun onFailure(call: Call<Netmodel>, t:Throwable) {
                Log.e("MainActivity",t.toString())
            }
            override fun onResponse(call: Call<Netmodel>, response: Response<Netmodel>) {
                if (response.isSuccessful) {
                    val ListBuku = response.body()!!.buku
                    adapterx.setDat(ListBuku)
//                    ListBuku.forEach {
//                        Log.e("MainActivity", "penulis ${it.penulis}")
//                    }
                        }
                  }
             })
          }
    }

