package au.com.softclient.multiscreensizeui_1.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

data class WindowSize(
    val width: WindowType,
    val height: WindowType,
)

enum class WindowType{
    Compact, Medium, Expanded
}

@Composable
fun rememberWindowSize(): WindowSize{
    val configuration = LocalConfiguration.current

    return WindowSize(
        width = when{
            configuration.screenWidthDp < 600 -> WindowType.Compact
            configuration.screenWidthDp < 840 -> WindowType.Medium
            else -> WindowType.Expanded
        },
        height = when{
            configuration.screenHeightDp < 600 -> WindowType.Compact
            configuration.screenHeightDp < 840 -> WindowType.Medium
            else -> WindowType.Expanded
        },
    );
}
