package br.com.moraesgabriel.forum.domain.controller

import br.com.moraesgabriel.forum.domain.dto.AnswerDTO
import br.com.moraesgabriel.forum.domain.model.Answer
import br.com.moraesgabriel.forum.domain.service.AnswerService
import br.com.moraesgabriel.forum.domain.service.TopicService
import br.com.moraesgabriel.forum.domain.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/topics/{id}/answers")
class AnswerController(
    private val answerService: AnswerService,
    private val topicService: TopicService,
    private val userService: UserService
) {


    @GetMapping
    fun list(@PathVariable id: Long): List<Answer> {
        return answerService.getAnswerByTopic(id)
    }

    @PostMapping
    fun registerAnswer(
        @PathVariable id: Long,
        @RequestBody answer: AnswerDTO
    ) {
        val topic = topicService
            .getTopicById(id)
        val author = userService.findAuthorById(answer.idAuthor)
        answerService.register(topic = topic, author = author, answerDTO = answer)
    }
}