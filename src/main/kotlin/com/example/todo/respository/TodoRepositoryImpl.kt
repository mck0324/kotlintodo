package com.example.todo.respository

import com.example.todo.database.Todo
import com.example.todo.database.TodoDataBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoRepositoryImpl(
): TodoRepository {
    @Autowired
    lateinit var TodoDatabase: TodoDataBase

    override fun save(todo: Todo): Todo {

        return todo.apply {
            this.index = ++TodoDatabase.index
        }.run {
            TodoDatabase.todoList.add(todo)
            this
        }

    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(todo: Todo): Todo {
        TODO("Not yet implemented")
    }

    override fun delete(index: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun findOne(index: Int): Todo {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<Todo> {
        TODO("Not yet implemented")
    }
}