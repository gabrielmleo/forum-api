package br.com.moraesgabriel.forum.domain.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class TopicDTO(
        @field:NotEmpty val title: String,
        @field:NotEmpty val message: String,
        @field:NotNull val idCourse: Long,
        @field:NotNull val idAuthor: Long
)
