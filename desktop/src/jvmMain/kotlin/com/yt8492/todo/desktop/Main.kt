package com.yt8492.todo.desktop

import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import com.yt8492.todo.common.bloc.TodoRootComponent
import com.yt8492.todo.common.ui.page.TodoRootPage

fun main() = Window {
    MaterialTheme {
        TodoRootPage(rememberRootComponent { componentContext ->
            TodoRootComponent(componentContext)
        })
    }
}