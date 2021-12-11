package com.yt8492.todo.web.ui.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.yt8492.todo.common.NavigationComponent
import com.yt8492.todo.common.bloc.TodoRootComponent
import com.yt8492.todo.common.bloc.TodoCreateComponent
import com.yt8492.todo.common.bloc.TodoDetailComponent
import com.yt8492.todo.common.bloc.TodoListComponent

@Composable
fun TodoRootPage(
    component: TodoRootComponent
) {
    val (currentComponent, setComponent) = remember {
        mutableStateOf<NavigationComponent?>(null)
    }
    component.routerState.subscribe {
        setComponent(it.activeChild.instance)
    }
    when (currentComponent) {
        is TodoListComponent -> {
            TodoListPage(currentComponent)
        }
        is TodoDetailComponent -> {
            TodoDetailPage(currentComponent)
        }
        is TodoCreateComponent -> {
            TodoCreatePage(currentComponent)
        }
    }
}
