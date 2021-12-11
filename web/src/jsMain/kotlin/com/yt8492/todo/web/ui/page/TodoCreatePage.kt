package com.yt8492.todo.web.ui.page

import androidx.compose.runtime.Composable
import app.softwork.routingcompose.Router
import com.yt8492.todo.common.data.TodoRepository

@Composable
fun TodoCreatePage() {
    val router = Router.current
    TodoCreateTemplate(
        onClickCreate = {
            TodoRepository.create(it)
            router.navigate("/")
        },
    )
}
