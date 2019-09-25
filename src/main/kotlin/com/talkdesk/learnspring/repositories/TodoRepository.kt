package com.talkdesk.learnspring.repositories

import com.talkdesk.learnspring.entities.Todo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : CrudRepository<Todo, String>{
}