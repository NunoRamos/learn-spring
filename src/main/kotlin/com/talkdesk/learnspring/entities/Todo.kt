package com.talkdesk.learnspring.entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Todo (
    @Id
    val id: String = UUID.randomUUID().toString(),
    var name: String?,
    var status: Boolean? = false
)