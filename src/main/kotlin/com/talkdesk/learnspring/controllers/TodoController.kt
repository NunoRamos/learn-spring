package com.talkdesk.learnspring.controllers

import org.springframework.http.ResponseEntity
import com.talkdesk.learnspring.repositories.TodoRepository
import com.talkdesk.learnspring.entities.Todo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(
        private val todoRepository: TodoRepository
){

    @GetMapping
    fun listTodos(): ResponseEntity<List<Todo>> {
        val todos = this.todoRepository.findAll()
        return ResponseEntity.ok(todos.toList())
    }

    @PostMapping
    fun createItem(@RequestBody todo: Todo) : Todo {
        return this.todoRepository.save(todo)
    }
}
