package br.com.moraesgabriel.forum.domain.controller

import br.com.moraesgabriel.forum.domain.dto.TopicDTO
import br.com.moraesgabriel.forum.domain.dto.TopicUpdateDTO
import br.com.moraesgabriel.forum.domain.dto.TopicView
import br.com.moraesgabriel.forum.domain.model.Course
import br.com.moraesgabriel.forum.domain.model.Topic
import br.com.moraesgabriel.forum.domain.model.User
import br.com.moraesgabriel.forum.domain.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): TopicView {
        return topicService.getTopicViewById(id)
    }


    @PostMapping
    fun register(@RequestBody @Valid topic: TopicDTO) {
        topicService.register(topic)
    }

    @PutMapping
    fun update(@RequestBody @Valid topicUpdate: TopicUpdateDTO) {
        topicService.update(topicUpdate)
    }
}