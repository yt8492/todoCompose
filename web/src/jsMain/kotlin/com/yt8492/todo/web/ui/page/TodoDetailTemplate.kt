package com.yt8492.todo.web.ui.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.yt8492.todo.common.data.Todo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextInput

@Composable
fun TodoDetailTemplate(
    todo: Todo,
    onClickEdit: (Todo) -> Unit,
    onClickDelete: () -> Unit,
) {
    Div(
        attrs = {
            style {
                width(100.percent)
                height(100.percent)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
            }
        },
    ) {
        Div(
            attrs = {
                style {
                    width(100.percent)
                    height(56.px)
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Row)
                    justifyContent(JustifyContent.SpaceBetween)
                }
            },
        ) {
            Text("Todo Create")
        }
        Div(
            attrs = {

            },
        ) {
            val (todoText, updateText) = remember { mutableStateOf(todo.text) }
            TextInput(
                value = todoText,
                attrs = {
                    onInput {
                        updateText(it.value)
                    }
                },
            )
            Button(
                attrs = {
                    onClick {
                        onClickEdit(todo.copy(text = todoText))
                    }
                },
            ) {
                Text("Edit")
            }
            Button(
                attrs = {
                    onClick {
                        onClickDelete()
                    }
                },
            ) {
                Text("Delete")
            }
        }
    }
}
