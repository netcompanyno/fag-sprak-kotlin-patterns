import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

// https://medium.com/@jozemberi/developing-with-kotlin-and-testing-with-spek-d69a94857d

@RunWith(JUnitPlatform::class)
class ExampleSpekTest : Spek({
    val x = 3
    val y = 2

    given("x = $x and y = $y") {
        val sum = x + y

        it("should be that x + y = 5") {
            assertEquals(5, sum)
        }

        it("should be that x - y = -1") {
            val subtract = y - x
            assertEquals(-1, subtract)
        }
    }
})