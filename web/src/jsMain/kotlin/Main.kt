import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.yt8492.todo.common.bloc.TodoRootComponent
import com.yt8492.todo.web.ui.page.TodoRootPage
import org.jetbrains.compose.web.renderComposable

fun main() {
    val lifecycle = LifecycleRegistry()
    val componentContext = DefaultComponentContext(lifecycle)
    renderComposable("root") {
        TodoRootPage(TodoRootComponent(componentContext))
    }
}
