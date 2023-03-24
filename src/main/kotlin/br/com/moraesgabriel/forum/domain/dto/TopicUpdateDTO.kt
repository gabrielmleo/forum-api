package br.com.moraesgabriel.forum.domain.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

class TopicUpdateDTO(
    @field:NotNull val id: Long,
    @field:NotEmpty val title: String,
    @field:NotEmpty val message: String
)
