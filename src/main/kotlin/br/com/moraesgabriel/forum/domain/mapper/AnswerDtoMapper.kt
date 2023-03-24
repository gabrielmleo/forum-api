package br.com.moraesgabriel.forum.domain.mapper

import br.com.moraesgabriel.forum.domain.dto.AnswerDTO
import br.com.moraesgabriel.forum.domain.model.Answer
import br.com.moraesgabriel.forum.domain.model.Topic
import br.com.moraesgabriel.forum.domain.model.User
import org.springframework.stereotype.Component

@Component
class AnswerDtoMapper {

    fun map(
        topic: Topic,
        author: User,
        answerDTO: AnswerDTO,
        answerId: Long
    ): Answer {
        return Answer(
            id = answerId,
            message = answerDTO.message,
            topic = topic,
            author = author
        )
    }
}