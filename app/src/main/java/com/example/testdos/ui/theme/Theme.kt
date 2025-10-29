package com.example.testdos.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

/*private val LightColorScheme = lightColorScheme(
    primary = BrightIndigo,
    onPrimary = White,

    primaryContainer = CustomDark,
    onPrimaryContainer = CustomWhite,

    secondary = GrayBlue,
    onSecondary = White,

    tertiary = RedAccent,
    onTertiary = Black,

    background = LightBackground,
    onBackground = OnLightText,

    surface = LightSurface,
    onSurface = OnLightText,

    outline = LightOutline,
    outlineVariant = LightOutlineVariant,

    error = ErrorLight,
    onError = White,

)

private val DarkColorScheme = darkColorScheme(
    primary = BrightIndigo,
    onPrimary = White,

    primaryContainer = CustomWhite,
    onPrimaryContainer = CustomDark,

    secondary = GrayBlue,
    onSecondary = White,

    tertiary = RedAccent,
    onTertiary = White,

    background = DarkBackground,
    onBackground = OnDarkText,

    surface = DarkSurface,
    onSurface = OnDarkText,

    outline = DarkOutline,
    outlineVariant = DarkOutlineVariant,

    error = ErrorDark,
    onError = White
)*/

private val LightColorScheme = lightColorScheme(
    primary = BrightIndigo,
    onPrimary = CustomWhite,

    // Mejor contraste y consistencia Material 3
    primaryContainer = BrightIndigo.copy(alpha = 0.15f),
    onPrimaryContainer = BrightIndigo,

    secondary = LowBlue,
    onSecondary = CustomWhite,
    secondaryContainer = LowBlue.copy(alpha = 0.15f),
    onSecondaryContainer = LowBlue,

    tertiary = PinkAccent,
    onTertiary = CustomWhite,
    tertiaryContainer = PinkAccent.copy(alpha = 0.15f),
    onTertiaryContainer = PinkAccent,

    background = LightBackground,
    onBackground = OnLightText,

    surface = LightSurface,
    onSurface = OnLightText,

    // ✅ Faltaban
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = OnLightSurfaceVariant,

    inverseSurface = InverseSurface,
    inverseOnSurface = InverseOnSurface,
    inversePrimary = InversePrimary,

    outline = LightOutline,
    outlineVariant = LightOutlineVariant,

    error = ErrorLight,
    onError = CustomWhite
)

private val DarkColorScheme = darkColorScheme(
    primary = BrightIndigo,
    onPrimary = CustomWhite,

    primaryContainer = BrightIndigo.copy(alpha = 0.25f),
    onPrimaryContainer = CustomWhite,

    secondary = LowBlue,
    onSecondary = CustomWhite,
    secondaryContainer = LowBlue.copy(alpha = 0.25f),
    onSecondaryContainer = CustomWhite,

    tertiary = PinkAccent,
    onTertiary = CustomWhite,
    tertiaryContainer = PinkAccent.copy(alpha = 0.25f),
    onTertiaryContainer = CustomWhite,

    background = DarkBackground,
    onBackground = OnDarkText,

    surface = DarkSurface,
    onSurface = OnDarkText,

    // ✅ Faltaban
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = OnDarkSurfaceVariant,

    inverseSurface = InverseSurface,
    inverseOnSurface = InverseOnSurface,
    inversePrimary = InversePrimary,

    outline = DarkOutline,
    outlineVariant = DarkOutlineVariant,

    error = ErrorDark,
    onError = CustomWhite
)

@Immutable
data class ExtendedColors(
    val success: Color,
    val warning: Color,
    val medium: Color,
    val disabled: Color,
)

val LightExtendedColors = ExtendedColors(
    success = SuccessLight,
    warning = WarningLight,
    medium = OnLightTextMedium,
    disabled = OnLightTextDisabled,
)

val DarkExtendedColors = ExtendedColors(
    success = SuccessDark,
    warning = WarningDark,
    medium = OnDarkTextMedium,
    disabled = OnDarkTextDisabled,
)

val LocalExtendedColors = staticCompositionLocalOf {
    // Proporciona una instancia predeterminada para evitar la falla si no se envuelve en un proveedor
    LightExtendedColors
}
@Composable
fun TestDosTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val extendedColors = if (darkTheme) DarkExtendedColors else LightExtendedColors
/*    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.setDecorFitsSystemWindows(window, false) // Importante para el modo edge-to-edge
            window.statusBarColor = Color.Transparent.toArgb() // Establece la barra de estado transparente

            // Opcional: ajusta el color de los iconos según el tema
            val insetsController = WindowCompat.getInsetsController(window, window.decorView)
            insetsController.isAppearanceLightStatusBars = !darkTheme
        }
    }*/
    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

val MaterialTheme.extendedColors: ExtendedColors
    @Composable
    @ReadOnlyComposable
    get() = LocalExtendedColors.current