package com.example.todo.respository

import com.example.todo.database.Todo
import com.example.todo.database.TodoDataBase
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl(
        val todoDatabase: TodoDataBase
): TodoRepository {


    override fun save(todo: Todo): Todo {

        return todo.apply {
            this.index = ++todoDatabase.index
            this.createdAt = LocalDateTime.now()
            this.updatedAt = LocalDateTime.now()
        }.run {
            todoDatabase.todoList.add(todo)
            this
        }

    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        return try {
            todoList.forEach {
                save(it)
            }
            true
        }catch (e: Exception) {
            false
        }
    }

    override fun update(todo: Todo): Todo {
        TODO("Not yet implemented")
    }

    override fun delete(index: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun findOne(index: Int): Todo? {
        return todoDatabase.todoList.first { it.index == index }
    }

    override fun findAll(): MutableList<Todo> {
        TODO("Not yet implemented")
    }
}