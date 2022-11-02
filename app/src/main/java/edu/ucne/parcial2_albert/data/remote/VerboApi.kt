package edu.ucne.parcial2_albert.data.remote

import edu.ucne.parcial2_albert.data.remote.dto.VerbosResponseDto
import retrofit2.Response
import retrofit2.http.*

interface VerboApi {
    @GET("verbos")
    suspend fun GetVerbos(): Response<List<VerbosResponseDto>>
}

