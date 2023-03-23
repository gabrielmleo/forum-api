package br.com.moraesgabriel.forum.domain.controller

import br.com.moraesgabriel.forum.domain.model.Answer
import br.com.moraesgabriel.forum.domain.service.AnswerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/topics/{id}/answers")
class AnswerController(private val answerService: AnswerService) {


    @GetMapping
    fun listar(@PathVariable id: Long): List<Answer> {
        return answerService.getAnswerByTopic(id)
    }
}