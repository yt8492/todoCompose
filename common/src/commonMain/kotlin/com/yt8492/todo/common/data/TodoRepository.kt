package com.yt8492.todo.common.data

object TodoRepository {
    private var id = 0
    private val todoMap = mutableMapOf<Int, Todo>()

    fun findById(todoId: Int): Todo? {
        return todoMap[todoId]
    }

    fun findAll(): List<Todo> {
        return todoMap.map { it.value }
    }

    fun create(todoText: String) {
        todoMap[id] = Todo(id, todoText)
        id++
    }

    fun delete(todoId: Int) {
        todoMap.remove(todoId)
    }

    fun edit(todo: Todo) {
        todoMap[todo.id] = todo
    }
}
