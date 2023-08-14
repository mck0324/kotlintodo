package com.example.todo.service

import com.example.todo.database.Todo
import com.example.todo.database.convertTodo

import com.example.todo.model.http.TodoDto
import com.example.todo.model.http.convertTodoDto
import com.example.todo.respository.TodoRepositoryImpl
import org.springframework.stereotype.Service

//현업에선
//변환시켜주는 라이브러리 사용(DB그대로가 아님)
//model mapper (java)
//kotlin reflexion

@Service
class TodoService (
        val todoRepositoryImpl: TodoRepositoryImpl
) {

    //C
    fun create(todoDto: TodoDto): TodoDto? {
        return todoDto.let {
            Todo().convertTodo(it)
        }.let {
            todoRepositoryImpl.save(it)
        }?.let {
            TodoDto().convertTodoDto(it)
        }
    }
    //R
    fun read(index:Int): TodoDto? {
        return todoRepositoryImpl.findOne(index)?.let {
            TodoDto().convertTodoDto(it)
        }
    }

    fun readAll(): MutableList<TodoDto> {
        return todoRepositoryImpl.findAll().map {
            TodoDto().convertTodoDto(it)
        }.toMutableList()
    }
    //U
    fun update(todoDto: TodoDto): TodoDto? {
        return todoDto.let {
            Todo().convertTodo(it)
        }.let {
            todoRepositoryImpl.save(it)
        }?.let {
            TodoDto().convertTodoDto(it)
        }
    }

    //D
    fun delete(index: Int): Boolean {
        return todoRepositoryImpl.delete(index)
    }
}