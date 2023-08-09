package com.example.todo.respository

import com.example.todo.database.Todo

interface TodoRepository {

    fun save(todo:Todo): Todo
    fun saveAll(todoList: MutableList<Todo>): Boolean

    fun update(todo: Todo): Todo
    fun delete(index: Int) : Boolean

    fun findOne(index: Int) : Todo?
    fun findAll(): MutableList<Todo>

}