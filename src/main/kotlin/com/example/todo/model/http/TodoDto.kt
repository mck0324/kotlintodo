package com.example.todo.model.http

import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class TodoDto (
        var index: Int?= null,

        @field:NotBlank
        var title: String?= null,

        var description: String?= null,

        @field:NotBlank
        //yyyy-MM-dd HH:mm:ss
        var schedule: String?= null,

        var createdAt: LocalDateTime?= null,

        var updatedAt: LocalDateTime?= null
)