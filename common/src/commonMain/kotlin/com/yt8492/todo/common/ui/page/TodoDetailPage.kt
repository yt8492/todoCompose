package com.yt8492.todo.common.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yt8492.todo.common.bloc.TodoDetailComponent

@Composable
fun TodoDetailPage(component: TodoDetailComponent) {
    val todo by remember { component.todo }
    Scaffold(
        topBar = {
            TopAppBar {
                TopAppBar(
                    title = {
                        Text("Todo Detail")
                    },
                    navigationIcon = {
                        IconButton(onClick = component.backToList) {
                            Icon(Icons.Outlined.ArrowBack, "back to list")
                        }
                    }
                )
            }
        }
    ) {
        todo?.let { todo ->
            val (todoText, updateText) = remember { mutableStateOf(todo.text) }
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                TextField(todoText, updateText)
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        component.edit(todoText)
                    }
                ) {
                    Text(
                        text = "Edit"
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        component.delete()
                    }
                ) {
                    Text(
                        text = "Delete"
                    )
                }
            }
        } ?: run {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
