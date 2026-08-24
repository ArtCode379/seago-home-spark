package seago.household.seagohomespark.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = SeagoPrimary,
    onPrimary = SeagoSurface,
    secondary = SeagoAccent,
    onSecondary = SeagoPrimaryDark,
    background = SeagoBackground,
    onBackground = SeagoText,
    surface = SeagoSurface,
    onSurface = SeagoText,
    surfaceVariant = SeagoChip,
    onSurfaceVariant = SeagoMuted,
    outline = SeagoBorder,
    tertiary = SeagoSuccess,
)

private val DarkColors = darkColorScheme(
    primary = SeagoAccent,
    onPrimary = SeagoPrimaryDark,
    secondary = SeagoAccent,
    background = SeagoPrimaryDark,
    surface = SeagoPrimary,
    onSurface = SeagoSurface,
)

@Composable
fun ProductAppKGUGNTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        content = content,
    )
}

