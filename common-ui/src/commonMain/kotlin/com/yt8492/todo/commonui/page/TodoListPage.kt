package com.yt8492.todo.commonui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.yt8492.todo.common.bloc.TodoListComponent
import com.yt8492.todo.commonui.component.TodoItem

@Composable
fun TodoListPage(component: TodoListComponent) {
    val todoList = component.todoList.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Todo List")
                },
                actions = {
                    IconButton(onClick = component.navigateToCreate) {
                        Icon(Icons.Outlined.Add, "create new todo")
                    }
                }
            )
        }
    ) {

        if (todoList.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Todo is empty.",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
            ) {
                itemsIndexed(todoList) { i, todo ->
                    TodoItem(todo) {
                        component.navigateToDetail(it.id)
                    }
                    if (i < todoList.lastIndex) {
                        Divider()
                    }
                }
            }
        }
    }
}
