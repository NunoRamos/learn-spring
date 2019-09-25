package controllers

import entities.Todo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import repositories.TodoRepository

@RestController
@RequestMapping("/todos")

class TodoController(
        private val todoRepository: TodoRepository){


    @GetMapping
    fun listtodos(): ResponseEntity<List<Todo>> {
        val todos = this.todoRepository.findAll()
        return ResponseEntity.ok(todos.toList())
    }
}
