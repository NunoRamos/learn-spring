package controllers

import org.springframework.web.bind.annotation.*
import repositories.TodoRepository
import entities.Todo

@RestController
@RequestMapping("/todos")

class TodoController(
        private val todoRepository: TodoRepository){

    @PostMapping
    fun createItem(@RequestBody todo: Todo) : Todo {
        return this.todoRepository.save(todo)
    }
}
