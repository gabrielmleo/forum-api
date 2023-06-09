package br.com.moraesgabriel.forum.domain.service

import br.com.moraesgabriel.forum.domain.dto.TopicDTO
import br.com.moraesgabriel.forum.domain.dto.TopicUpdateDTO
import br.com.moraesgabriel.forum.domain.dto.TopicView
import br.com.moraesgabriel.forum.domain.mapper.TopicDtoMapper
import br.com.moraesgabriel.forum.domain.mapper.TopicViewMapper
import br.com.moraesgabriel.forum.domain.model.Topic
import org.springframework.stereotype.Service


@Service
class TopicService(
        private var topics: ArrayList<Topic> = arrayListOf(),
        private val courseService: CourseService,
        private val userService: UserService,
        private val topicViewMapper: TopicViewMapper,
        private val topicDtoMapper: TopicDtoMapper
) {

    fun list(): List<TopicView> {
        return topics.map {topic ->
            topicViewMapper.map(topic)
        }
    }

    fun getTopicViewById(id: Long): TopicView {
        return topics.first { topic ->
            topic.id == id
        }.let {
            topicViewMapper.map(it)
        }
    }

    fun getTopicById(id: Long): Topic {
        return topics.first { topic ->
            topic.id == id
        }
    }

    fun register(topicDto: TopicDTO): TopicView {
        val topic = topicDtoMapper.map(
            t = topicDto,
            id = topics.size.toLong() + 1,
            course = courseService.findCourseById(topicDto.idCourse),
            author = userService.findAuthorById(topicDto.idAuthor)
        )
        topics.add(topic)
        return topicViewMapper.map(topic)
    }

    fun update(topicUpdate: TopicUpdateDTO): TopicView {
        val oldTopic: Topic = topics.first {
            it.id == topicUpdate.id
        }
        val newTopic = Topic(
            id = topicUpdate.id
            , title = topicUpdate.title,
            message = topicUpdate.message,
            creationDate = oldTopic.creationDate,
            course = oldTopic.course,
            author = oldTopic.author,
            status = oldTopic.status,
            answers = oldTopic.answers
        )
        topics.remove(oldTopic)
        topics.add(newTopic)
        return topicViewMapper.map(newTopic)
    }

    fun deleteTopicById(id: Long) {
        val oldTopic = topics.first {
            it.id == id
        }

        topics.remove(oldTopic)
    }
}