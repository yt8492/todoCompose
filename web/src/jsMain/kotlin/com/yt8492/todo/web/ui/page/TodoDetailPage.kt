package com.yt8492.todo.web.ui.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.yt8492.todo.common.bloc.TodoDetailComponent
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextInput

@Composable
fun TodoDetailPage(component: TodoDetailComponent) {
    val todo = remember { component.todo }.value
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
            todo?.let { todo ->
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
                            component.edit(todoText)
                        }
                    },
                ) {
                    Text("Edit")
                }
                Button(
                    attrs = {
                        onClick {
                            component.delete()
                        }
                    },
                ) {
                    Text("Delete")
                }
            }
        }
    }
}
