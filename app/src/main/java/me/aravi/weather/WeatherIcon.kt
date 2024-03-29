package me.aravi.weather

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults.IconSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import me.aravi.weather.widgets.*

/**
 * show current weather's animation on top of [WeatherView]
 */
@Composable
fun ComposedIcon(modifier: Modifier = Modifier, composeInfo: ComposeInfo) {

    val (sun, cloud, lightCloud, rains, lightRain, snow, thunder) = composeInfo
    Box(modifier = modifier.size(IconSize)) {

        val _modifier = remember(Unit) {
            { icon: IconInfo ->
                Modifier
                    .offset(
                        icon.size * icon.offset.x,
                        icon.size * icon.offset.y
                    )
                    .size(icon.size * icon.sizeRatio)
                    .alpha(icon.alpha)
            }
        }

        AnimatedSun(_modifier(sun))

        AnimatableRains(_modifier(rains))

        AnimatableRains(_modifier(lightRain), true) // light rain

        AnimatableSnow(_modifier(snow))

        AnimatedCloud(_modifier(cloud))

        AnimatedCloud(_modifier(lightCloud), 1000) // light cloud

        AnimatedThunder(_modifier(thunder))
    }
}