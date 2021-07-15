package com.yt8492.todo.common.bloc

import com.arkivanov.decompose.ComponentContext
import com.yt8492.todo.common.NavigationComponent
import com.yt8492.todo.common.data.TodoRepository

class TodoCreateComponent(
    componentContext: ComponentContext,
    val backToList: () -> Unit
) : NavigationComponent, ComponentContext by componentContext {

    fun create(
        todoText: String
    ) {
        TodoRepository.create(todoText)
        backToList()
    }
}