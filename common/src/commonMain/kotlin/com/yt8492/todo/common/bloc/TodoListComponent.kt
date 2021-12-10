package com.yt8492.todo.common.bloc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import com.yt8492.todo.common.NavigationComponent
import com.yt8492.todo.common.data.Todo
import com.yt8492.todo.common.data.TodoRepository

class TodoListComponent(
    componentContext: ComponentContext,
    val navigateToDetail: (todoId: Int) -> Unit,
    val navigateToCreate: () -> Unit
) : NavigationComponent, ComponentContext by componentContext {

    val todoList: State<List<Todo>>
        @Composable get() = TodoRepository.todoFlow.collectAsState(
            listOf()
        )
}
