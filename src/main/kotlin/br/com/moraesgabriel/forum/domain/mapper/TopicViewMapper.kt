package br.com.moraesgabriel.forum.domain.mapper

import br.com.moraesgabriel.forum.domain.dto.TopicView
import br.com.moraesgabriel.forum.domain.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper {

    fun map(t: Topic): TopicView {
        return TopicView(
                id = t.id,
                title = t.title,
                message = t.message,
                status = t.status,
                creationDate = t.creationDate
        )
    }
}