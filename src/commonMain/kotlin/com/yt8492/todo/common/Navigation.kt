package com.yt8492.todo.common

import com.arkivanov.decompose.statekeeper.Parcelable
import com.arkivanov.decompose.statekeeper.Parcelize

sealed interface Navigation : Parcelable {

    @Parcelize
    object List : Navigation

    @Parcelize
    data class Detail(val todoId: Int) : Navigation

    @Parcelize
    object Create : Navigation
}