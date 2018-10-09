package me.rozkmin.testing.junit4

import me.rozkmin.testing.application.DistanceConverter
import me.rozkmin.testing.application.Kilometer
import me.rozkmin.testing.application.Meter
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class DistanceConverterParameterizedTest(private val input: Input){
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Input> {
            return listOf(
                    Input(500, 0.5),
                    Input(750, 0.8)
            )
        }
    }

    @Test
    fun `check distance parser`(){
        val distanceConverter = DistanceConverter()

        val actual = distanceConverter.parse(input.parameter)
        val expected = input.expected

        assertEquals(actual, expected, 0.0)
    }


    data class Input(val parameter: Meter, val expected: Kilometer)
}