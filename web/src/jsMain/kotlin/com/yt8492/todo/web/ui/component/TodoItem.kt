package com.yt8492.todo.web.ui.component

import androidx.compose.runtime.Composable
import com.yt8492.todo.common.data.Todo
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun TodoItem(
    todo: Todo,
    onClick: (Todo) -> Unit
) {
    Div(
        attrs = {
            onClick {
                onClick(todo)
                style {
                    padding(16.px)
                    fontSize(20.px)
                }
            }
        },
    ) {
        Text(todo.text)
    }
}
