package com.yt8492.todo.common.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object TodoRepository {
    private var id = 0
    private val _todoFlow = MutableStateFlow(listOf<Todo>())
    val todoFlow: StateFlow<List<Todo>> get() = _todoFlow

    fun findById(todoId: Int): Todo? {
        return _todoFlow.value.find {
            it.id == todoId
        }
    }

    fun findAll(): List<Todo> {
        return _todoFlow.value
    }

    fun create(todoText: String) {
        _todoFlow.value = _todoFlow.value + Todo(id, todoText)
        id++
    }

    fun delete(todoId: Int) {
        _todoFlow.value = _todoFlow.value.filter {
            it.id == todoId
        }
    }

    fun edit(todo: Todo) {
        val todos = _todoFlow.value.toMutableList()
        val i = todos.indexOfFirst {
            it.id == todo.id
        }
        if (i != -1) {
            todos[i] = todo
        }
        _todoFlow.value = todos
    }
}
