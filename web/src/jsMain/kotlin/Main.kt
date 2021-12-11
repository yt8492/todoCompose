import com.yt8492.todo.web.ui.page.TodoRootPage
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable("root") {
        TodoRootPage()
    }
}
