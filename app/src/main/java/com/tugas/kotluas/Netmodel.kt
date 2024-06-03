package com.tugas.kotluas

import com.google.gson.annotations.SerializedName

data class Netmodel(
    @SerializedName("buku") val buku: List<Buku>
) {
    data class Buku(
        @SerializedName("id_buku") val idBuku: String?,
        @SerializedName("judul_buku") val judulBuku: String?,
        @SerializedName("penulis") val penulis: String?,
        @SerializedName("tahun_terbit") val tahunTerbit: String?
    )
        :java.io.Serializable

}
