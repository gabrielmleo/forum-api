package br.com.moraesgabriel.forum.domain.mapper

import br.com.moraesgabriel.forum.domain.dto.TopicDTO
import br.com.moraesgabriel.forum.domain.model.Course
import br.com.moraesgabriel.forum.domain.model.Topic
import br.com.moraesgabriel.forum.domain.model.User
import org.springframework.stereotype.Component

@Component
class TopicDtoMapper() {
    fun map(
            t: TopicDTO,
            id: Long,
            course: Course,
            author: User
    ): Topic {
        return Topic(
                id = id,
                title = t.title,
                message = t.message,
                course = course,
                author = author
        )
    }
}