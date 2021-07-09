package com.yt8492.todo

import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import com.yt8492.todo.common.TodoRootComponent
import com.yt8492.todo.common.ui.page.TodoRootPage

fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        TodoRootPage(rememberRootComponent { componentContext ->
            TodoRootComponent(componentContext)
        })
    }
}