import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.runtime.SideEffect
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SetupStatusBar() {
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()

    val color = MaterialTheme.colorScheme.primary // ✅ dentro de un Composable

    SideEffect {
        systemUiController.setStatusBarColor(
            color = color,
            darkIcons = false
        )
    }
}
