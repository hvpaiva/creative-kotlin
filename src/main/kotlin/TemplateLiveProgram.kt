import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.olive.oliveProgram
import kotlin.math.cos
import kotlin.math.sin

/**
 *  This is a template for a live program.
 *
 *  It uses oliveProgram {} instead of program {}. All code inside the
 *  oliveProgram {} can be changed while the program is running.
 */

fun main() = application {
    configure {
        width = 600
        height = 800
    }
    oliveProgram {
        extend {
            val center = width / 2.0 with height / 2.0
            drawer.clear(ColorRGBa.fromHex("2F2F2FFF"))

            drawer.fill = null

            val colors = listOf(
                ColorRGBa.fromHex("#e1e1e1"),
                ColorRGBa.fromHex("#cbcbcb"),
                ColorRGBa.fromHex("#939393"),
                ColorRGBa.fromHex("#4b4b4b")
            )

            (1..360 step 16).forEach {
                val rad = Math.toRadians(it.toDouble()) * cos(seconds)
                val x = center.x + cos(rad) * 200.0 * sin(seconds)
                val y = center.y + sin(rad) * 200.0 * cos(seconds)

                drawer.stroke = colors[it % colors.size]
                drawer.circle(x, y, 100.0)
            }

        }
    }
}

data class Point(val x: Double, val y: Double)

infix fun Double.with(other: Double) = Point(this, other)