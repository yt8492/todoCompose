package com.yt8492.todo.desktop

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.singleWindowApplication
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import com.yt8492.todo.common.bloc.TodoRootComponent
import com.yt8492.todo.common.ui.page.TodoRootPage

fun main() = singleWindowApplication {
    MaterialTheme {
        TodoRootPage(rememberRootComponent { componentContext ->
            TodoRootComponent(componentContext)
        })
    }
}