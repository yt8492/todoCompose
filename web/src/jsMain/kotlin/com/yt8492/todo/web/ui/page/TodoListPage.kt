package com.yt8492.todo.web.ui.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import app.softwork.routingcompose.Router
import com.yt8492.todo.common.bloc.TodoListComponent
import com.yt8492.todo.common.data.Todo
import com.yt8492.todo.common.data.TodoRepository
import com.yt8492.todo.web.ui.component.Divider
import com.yt8492.todo.web.ui.component.TodoItem
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun TodoListPage() {
    val router = Router.current
    val todoList = TodoRepository.todoFlow.collectAsState().value
    TodoListTemplate(
        todoList = todoList,
        onClickTodo = {
            router.navigate("/${it.id}")
        },
        onClickCreate = {
            router.navigate("/create")
        }
    )
}
