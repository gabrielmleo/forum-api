package br.com.moraesgabriel.forum.domain.model

import java.time.LocalDateTime

data class Topic(
        val id: Long? = null,
        val title: String,
        val message: String,
        val creationDate: LocalDateTime = LocalDateTime.now(),
        val course: Course,
        val author: User,
        val status: TopicStatus = TopicStatus.NOT_RESPOND,
        val answers: List<Answer> = arrayListOf()
)
