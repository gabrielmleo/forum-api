package br.com.moraesgabriel.forum.domain.controller

import br.com.moraesgabriel.forum.domain.dto.TopicDTO
import br.com.moraesgabriel.forum.domain.dto.TopicUpdateDTO
import br.com.moraesgabriel.forum.domain.dto.TopicView
import br.com.moraesgabriel.forum.domain.model.Course
import br.com.moraesgabriel.forum.domain.model.Topic
import br.com.moraesgabriel.forum.domain.model.User
import br.com.moraesgabriel.forum.domain.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


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
    fun register(
        @RequestBody @Valid topic: TopicDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = topicService.register(topic)
        val uri = uriBuilder.path("topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun update(@RequestBody @Valid topicUpdate: TopicUpdateDTO): ResponseEntity<TopicView> {
        val topicUpdated = topicService.update(topicUpdate)
        return ResponseEntity.ok(topicUpdated)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        topicService.deleteTopicById(id)
    }
}