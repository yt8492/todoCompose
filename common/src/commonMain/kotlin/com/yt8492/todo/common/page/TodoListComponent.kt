package com.yt8492.todo.common.page

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import com.yt8492.todo.common.NavigationComponent
import com.yt8492.todo.common.Todo
import com.yt8492.todo.common.TodoRepository

class TodoListComponent(
    componentContext: ComponentContext,
    val navigateToDetail: (todoId: Int) -> Unit,
    val navigateToCreate: () -> Unit
) : NavigationComponent, ComponentContext by componentContext {

    private val _todoList = mutableStateOf<List<Todo>>(listOf())
    val todoList: State<List<Todo>> = _todoList

    init {
        _todoList.value = TodoRepository.findAll()
    }

    fun refresh() {
        _todoList.value = TodoRepository.findAll()
    }
}