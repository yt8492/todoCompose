package com.yt8492.todo.desktop

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.singleWindowApplication
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.yt8492.todo.common.bloc.TodoRootComponent
import com.yt8492.todo.commonui.page.TodoRootPage

fun main() = singleWindowApplication {
    val lifecycle = LifecycleRegistry()
    val componentContext = DefaultComponentContext(lifecycle)
    MaterialTheme {
        TodoRootPage(TodoRootComponent(componentContext))
    }
}