import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SetupStatusBar(
    statusBarColor: Color = MaterialTheme.colorScheme.primary
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Dibuja el fondo en el área del status bar
        Box(
            modifier = Modifier
                .windowInsetsTopHeight(WindowInsets.statusBars)
                .background(statusBarColor)
        )

        // El resto del contenido
        Box(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
            /*    .background(Color.Blue)*/
        ) {
            // Tu UI acá
        }
    }
}