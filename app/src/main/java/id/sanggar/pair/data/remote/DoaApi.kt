package id.sanggar.pair.data.remote

import id.sanggar.pair.data.entity.DoaList
import retrofit2.http.GET

interface DoaApi {
    @GET("dua.json")
    suspend fun doa(): Result<DoaList>
}