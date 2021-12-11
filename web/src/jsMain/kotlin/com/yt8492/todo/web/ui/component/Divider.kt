package com.yt8492.todo.web.ui.component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div

@Composable
fun Divider() {
    Div(
        attrs = {
            style {
                width(100.percent)
                height(1.px)
            }
        },
    )
}
