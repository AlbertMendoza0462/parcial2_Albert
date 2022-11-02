package edu.ucne.parcial2_albert.ui.entity

import edu.ucne.parcial2_albert.data.remote.dto.VerbosResponseDto

data class VerboState(
    val verbos: List<VerbosResponseDto> = emptyList(),
    val error: String = ""
)
