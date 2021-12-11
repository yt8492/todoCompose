package com.yt8492.todo.web.ui.page

import androidx.compose.runtime.Composable
import com.yt8492.todo.common.data.Todo
import com.yt8492.todo.web.ui.component.Divider
import com.yt8492.todo.web.ui.component.TodoItem
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun TodoListTemplate(
    todoList: List<Todo>,
    onClickTodo: (Todo) -> Unit,
    onClickCreate: () -> Unit,
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
            Text("Todo List")
            Button(
                attrs = {
                    onClick {
                        onClickCreate()
                    }
                }
            ) {
                Text("+")
            }
        }
        if (todoList.isEmpty()) {
            Div(
                attrs = {
                    style {
                        width(100.percent)
                        height(100.percent)
                        display(DisplayStyle.Flex)
                        justifyContent(JustifyContent.Center)
                        alignItems(AlignItems.Center)
                        fontSize(24.px)
                    }
                },
            ) {
                Text("Todo is empty.")
            }
        } else {
            todoList.forEachIndexed { i, todo ->
                TodoItem(todo) {
                    onClickTodo(todo)
                }
                if (i < todoList.lastIndex) {
                    Divider()
                }
            }
        }
    }
}
