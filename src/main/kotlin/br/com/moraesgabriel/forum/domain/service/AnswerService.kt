package br.com.moraesgabriel.forum.domain.service

import br.com.moraesgabriel.forum.domain.model.Answer
import br.com.moraesgabriel.forum.domain.model.Course
import br.com.moraesgabriel.forum.domain.model.Topic
import br.com.moraesgabriel.forum.domain.model.User
import org.springframework.stereotype.Service



@Service
class AnswerService(private var answer: List<Answer>) {

    init {
        answer = List(2) {
            Answer(
                    id = it.toLong(),
                    message = "This is a answer $it",
                    author = User(
                            id = 1,
                            name = "João Gabriel",
                            email = "jogaogabriel@email.com"
                    ),
                    topic = Topic(
                            id = 1,
                            title = "Kotlin",
                            message = "Kotlin variables",
                            course = Course(
                                    id = 1,
                                    name = "Kotlin",
                                    category = "Programing language"
                            ),
                            author = User(
                                    id = 1,
                                    name = "João Gabriel",
                                    email = "jogaogabriel@email.com"
                            )
                    ),
                    isSolution = false
            )
        }
    }

    fun getAnswerByTopic(id: Long): List<Answer> {
        return answer.filter {
            it.topic.id == id
        }
    }
}