package com.yt8492.todo.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import com.yt8492.todo.common.bloc.TodoRootComponent
import com.yt8492.todo.common.ui.page.TodoRootPage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoRootPage(rememberRootComponent { componentContext ->
                TodoRootComponent(componentContext)
            })
        }
    }
}