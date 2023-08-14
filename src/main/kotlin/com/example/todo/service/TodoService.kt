package com.example.todo.service

import com.example.todo.database.Todo
import com.example.todo.database.convertTodoDto
import com.example.todo.model.http.TodoDto
import com.example.todo.respository.TodoRepositoryImpl
import org.springframework.stereotype.Service


@Service
class TodoService (
        val todoRepositoryImpl: TodoRepositoryImpl
) {

    //C
    fun create(todoDto: TodoDto): Todo? {
        return todoDto.let {
            Todo().convertTodoDto(it)
        }.let {
            todoRepositoryImpl.save(it)
        }
    }
    //R
    fun read(index:Int): Todo? {
        return todoRepositoryImpl.findOne(index)
    }

    fun readAll(): MutableList<Todo> {
        return todoRepositoryImpl.findAll()
    }
    //U
    fun update(todoDto: TodoDto): Todo? {
        return todoDto.let {
            Todo().convertTodoDto(it)
        }.let {
            todoRepositoryImpl.save(it)
        }
    }

    //D
    fun delete(index: Int): Boolean {
        return todoRepositoryImpl.delete(index)
    }
}