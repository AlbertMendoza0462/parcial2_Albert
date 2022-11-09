package edu.ucne.parcial2_albert.data.Repository

import edu.ucne.parcial2_albert.data.remote.VerboApi
import edu.ucne.parcial2_albert.data.remote.dto.VerbosResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class VerboApiRepository @Inject constructor(
    private val api: VerboApi
) {
    suspend fun getVerbos(): List<VerbosResponseDto> {
        try {
            return withContext(Dispatchers.IO) {
                val response = api.GetVerbos()
                response.body() ?: emptyList()
            }
        } catch (e: Exception) {
            throw e
        }
    }

}