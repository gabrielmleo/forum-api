package br.com.moraesgabriel.forum.domain.service

import br.com.moraesgabriel.forum.domain.model.User
import org.springframework.stereotype.Service

@Service
class UserService(private var authors: List<User>) {

    init {
        authors = List(size = 4) {
            User(
                    id = it.toLong(),
                    name = "Kotlin $it",
                    email = "joao@email.com"
            )
        }
    }

    fun findAuthorById(id: Long): User {
        return this.authors.first {
            it.id == id
        }
    }

}
