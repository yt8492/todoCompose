package com.yt8492.todo.common

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

sealed interface Navigation : Parcelable {

    @Parcelize
    object List : Navigation

    @Parcelize
    data class Detail(val todoId: Int) : Navigation

    @Parcelize
    object Create : Navigation
}
