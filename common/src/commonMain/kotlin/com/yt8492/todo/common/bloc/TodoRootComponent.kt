package com.yt8492.todo.common.bloc

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.push
import com.arkivanov.decompose.router.router
import com.yt8492.todo.common.Navigation
import com.yt8492.todo.common.NavigationComponent

class TodoRootComponent(
    componentContext: ComponentContext
) : NavigationComponent, ComponentContext by componentContext {

    private val router = router<Navigation, NavigationComponent>(
        initialConfiguration = Navigation.List,
        handleBackButton = true,
        childFactory = { configuration, componentContext ->
            childFactory(configuration, componentContext)
        },
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
