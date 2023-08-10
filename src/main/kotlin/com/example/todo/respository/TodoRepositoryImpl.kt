package com.example.todo.respository

import com.example.todo.database.Todo
import com.example.todo.database.TodoDataBase
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl(
        val todoDatabase: TodoDataBase
): TodoRepository {


    override fun save(todo: Todo): Todo? {

        //1. index 있을경우
        //update
        return todo.index?.let {index ->
            findOne(index)?.apply {
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule
                this.updatedAt = LocalDateTime.now()
            }

        }?: kotlin.run {
            //없을경우
            //insert
            todo.apply {
                this.index = ++todoDatabase.index
                this.createdAt = LocalDateTime.now()
                this.updatedAt = LocalDateTime.now()
            }. run {
                todoDatabase.todoList.add(todo)
                this
            }
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


    override fun delete(index: Int): Boolean {
        return findOne(index)?.let {
            todoDatabase.todoList.remove(it)
            true
        }?: kotlin.run {
            false
        }
    }

    override fun findOne(index: Int): Todo? {
        return todoDatabase.todoList.first { it.index == index }
    }

    override fun findAll(): MutableList<Todo> {
        return todoDatabase.todoList
    }
}