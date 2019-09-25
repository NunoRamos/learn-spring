package controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import repositories.TodoRepository

@RestController
@RequestMapping("/todos")

class TodoController(
        private val todoRepository: TodoRepository){

    //Rotas
}
