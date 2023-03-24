package br.com.moraesgabriel.forum.domain.dto

import jakarta.validation.constraints.NotEmpty

data class AnswerDTO(
    @field:NotEmpty val message: String,
    @field:NotEmpty val idAuthor: Long,
    @field:NotEmpty val isSolution: Boolean
)
