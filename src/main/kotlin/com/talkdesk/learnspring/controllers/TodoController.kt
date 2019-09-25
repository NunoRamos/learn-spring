package com.talkdesk.learnspring.controllers

import org.springframework.http.ResponseEntity
import com.talkdesk.learnspring.repositories.TodoRepository
import com.talkdesk.learnspring.entities.Todo
import org.springframework.http.HttpStatus
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

    @PutMapping("{id}")
    fun updateItem(@PathVariable id: String, @RequestBody todo: Todo) : ResponseEntity<Todo> {
        val item = this.todoRepository.findById(id)
        if (item.isPresent)
            return ResponseEntity.ok(item.get())

        return ResponseEntity.badRequest().body(todo)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String ) : ResponseEntity<Todo>{

        if(this.todoRepository.existsById(id)) {
            this.todoRepository.deleteById(id)
        }
        else {
            return ResponseEntity.notFound().build()
        }

        return ResponseEntity.ok().build()
    }
}
