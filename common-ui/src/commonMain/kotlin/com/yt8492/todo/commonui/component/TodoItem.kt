package com.yt8492.todo.commonui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yt8492.todo.common.data.Todo

@Composable
fun TodoItem(
    todo: Todo,
    onClick: (Todo) -> Unit
) {
    Column(
        modifier = Modifier
            .clickable {
                onClick(todo)
            }
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = todo.text,
            fontSize = 20.sp
        )
    }
}
