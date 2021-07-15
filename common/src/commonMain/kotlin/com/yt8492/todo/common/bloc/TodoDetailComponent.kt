package com.yt8492.todo.common.bloc

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import com.yt8492.todo.common.NavigationComponent
import com.yt8492.todo.common.data.Todo
import com.yt8492.todo.common.data.TodoRepository

class TodoDetailComponent(
    private val todoId: Int,
    componentContext: ComponentContext,
    val backToList: () -> Unit
) : NavigationComponent, ComponentContext by componentContext {

    private val _todo = mutableStateOf<Todo?>(null)
    val todo: State<Todo?> get() = _todo

    init {
        _todo.value = TodoRepository.findById(todoId)
    }

    fun edit(newText: String) {
        todo.value?.let {
            val updated = it.copy(text = newText)
            TodoRepository.edit(updated)
        }
    }

    fun delete() {
        TodoRepository.delete(todoId)
        backToList()
    }
}
