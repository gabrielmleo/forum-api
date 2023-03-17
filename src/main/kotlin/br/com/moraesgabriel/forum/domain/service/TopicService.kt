package br.com.moraesgabriel.forum.domain.service

import br.com.moraesgabriel.forum.domain.model.Course
import br.com.moraesgabriel.forum.domain.model.Topic
import br.com.moraesgabriel.forum.domain.model.User
import org.springframework.stereotype.Service


@Service
class TopicService {
    fun list(): List<Topic> {
        val topicList = List(3) {
            Topic(
                    id = it.toLong(),
                    title = "Duvida Kotlin",
                    message = "Variaveis no Kotlin",
                    course = Course(
                            id = it.toLong(),
                            name = "Kotlin",
                            category = "Programing Language"
                    ),
                    author = User(
                            id = it.toLong(),
                            name = "Ana da Silva",
                            email = "ana@email.com"
                    )
            )
        }

        return topicList
    }
}