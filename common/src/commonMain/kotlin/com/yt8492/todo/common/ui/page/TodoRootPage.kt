package com.yt8492.todo.common.ui.page

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.yt8492.todo.common.bloc.TodoRootComponent
import com.yt8492.todo.common.bloc.TodoCreateComponent
import com.yt8492.todo.common.bloc.TodoDetailComponent
import com.yt8492.todo.common.bloc.TodoListComponent

@Composable
fun TodoRootPage(
    component: TodoRootComponent
) {
    Children(component.routerState) {
        when (val child = it.instance) {
            is TodoListComponent -> {
                TodoListPage(child)
            }
            is TodoDetailComponent -> {
                TodoDetailPage(child)
            }
            is TodoCreateComponent -> {
                TodoCreatePage(child)
            }
        }
    }
}
