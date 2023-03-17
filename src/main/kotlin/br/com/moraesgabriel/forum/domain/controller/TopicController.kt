package br.com.moraesgabriel.forum.domain.controller

import br.com.moraesgabriel.forum.domain.model.Course
import br.com.moraesgabriel.forum.domain.model.Topic
import br.com.moraesgabriel.forum.domain.model.User
import br.com.moraesgabriel.forum.domain.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(): List<Topic> {
        return topicService.list()
    }
}