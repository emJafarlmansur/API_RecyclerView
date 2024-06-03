package com.tugas.kotluas


import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface InterfaceEndpoint {
    @GET("tampildata.php")
    fun tampildata() : Call<Netmodel>

    @FormUrlEncoded
    @POST("simpan.php")
    fun simpan(
        @Field("judul_buku") judulBuku: String,
        @Field("penulis") penulis: String,
        @Field("tahun_terbit") tahunTerbit: String
    ):Call<SumbitMOdel>

    @FormUrlEncoded
    @POST("update.php")
    fun update(
        @Field("id_buku") idBuku: String,
        @Field("judul_buku") judulBuku: String,
        @Field("penulis") penulis: String,
        @Field("tahun_terbit") tahunTerbit: String,
    ):Call<SumbitMOdel>

    @FormUrlEncoded
    @POST("hapus.php")
    fun hapus(
        @Field("id_buku")idBuku: String
    ):Call<SumbitMOdel>
}
