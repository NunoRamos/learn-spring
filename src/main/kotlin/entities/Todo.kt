package entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Todo (
    @Id
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val status: Boolean
)