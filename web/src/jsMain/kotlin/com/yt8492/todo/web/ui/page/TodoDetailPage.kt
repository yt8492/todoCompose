package com.yt8492.todo.web.ui.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import app.softwork.routingcompose.Router
import com.yt8492.todo.common.bloc.TodoDetailComponent
import com.yt8492.todo.common.data.Todo
import com.yt8492.todo.common.data.TodoRepository
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextInput

@Composable
fun TodoDetailPage(
    id: Int,
) {
    val router = Router.current
    val todo = TodoRepository.findById(id)
    if (todo != null) {
        TodoDetailTemplate(
            todo = todo,
            onClickEdit = {
                TodoRepository.edit(it)
                router.navigate("/")
            },
            onClickDelete = {
                TodoRepository.delete(id)
                router.navigate("/")
            },
        )
    }
}
