package br.com.moraesgabriel.forum.domain.service

import br.com.moraesgabriel.forum.domain.model.Course
import org.springframework.stereotype.Service




@Service
class CourseService(private var course: List<Course>) {

    init {
        course = List(size = 4) {
            Course(
                    id = it.toLong(),
                    name = "Kotlin $it",
                    category = "Programing Language"
            )
        }
    }

    fun findCourseById(id: Long): Course {
        return this.course.first {
            it.id == id
        }
    }
}
