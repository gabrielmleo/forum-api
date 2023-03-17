package br.com.moraesgabriel.forum.domain.service

import br.com.moraesgabriel.forum.domain.model.Course
import br.com.moraesgabriel.forum.domain.model.Topic
import br.com.moraesgabriel.forum.domain.model.User
import org.springframework.stereotype.Service


@Service
class TopicService(private var topics: List<Topic>) {

    init {
        topics = List(3) {
            Topic(
                    id = it.toLong(),
                    title = "Duvida Kotlin $it",
                    message = "Variaveis no Kotlin $it",
                    course = Course(
                            id = it.toLong(),
                            name = "Kotlin",
                            category = "Programing Language"
                    ),
                    author = User(
                            id = it.toLong(),
                            name = "Ana da Silva $it",
                            email = "ana@email.com"
                    )
            )
        }
    }
    fun list(): List<Topic> {
        return topics
    }

    fun getTopicById(id: Long): Topic {
        return topics.first { topic ->
            topic.id == id
        }
    }
}