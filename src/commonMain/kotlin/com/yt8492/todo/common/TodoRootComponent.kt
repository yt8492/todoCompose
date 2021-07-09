package com.yt8492.todo.common

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.RouterState
import com.arkivanov.decompose.pop
import com.arkivanov.decompose.push
import com.arkivanov.decompose.router
import com.arkivanov.decompose.value.Value
import com.yt8492.todo.common.page.TodoCreateComponent
import com.yt8492.todo.common.page.TodoDetailComponent
import com.yt8492.todo.common.page.TodoListComponent

class TodoRootComponent(
    componentContext: ComponentContext
) : NavigationComponent, ComponentContext by componentContext {

    private val router = router<Navigation, NavigationComponent>(
        initialConfiguration = Navigation.List,
        handleBackButton = true,
        childFactory = ::childFactory
    )

    val routerState = router.state

    private fun childFactory(
        navigation: Navigation,
        componentContext: ComponentContext
    ): NavigationComponent {
        return when (navigation) {
            is Navigation.List -> TodoListComponent(
                componentContext = componentContext,
                navigateToDetail = {
                    router.push(Navigation.Detail(it))
                },
                navigateToCreate = {
                    router.push(Navigation.Create)
                }
            )
            is Navigation.Detail -> TodoDetailComponent(
                todoId = navigation.todoId,
                componentContext = componentContext,
                backToList = router::pop
            )
            is Navigation.Create -> TodoCreateComponent(
                componentContext = componentContext,
                backToList = router::pop
            )
        }
    }
}
