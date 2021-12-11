package com.yt8492.todo.web.ui.page

import androidx.compose.runtime.Composable
import app.softwork.routingcompose.HashRouter

@Composable
fun TodoRootPage() {
    HashRouter("/") {
        route("create") {
            TodoCreatePage()
        }
        int { id ->
            TodoDetailPage(id)
        }
        noMatch {
            TodoListPage()
        }
    }
}
