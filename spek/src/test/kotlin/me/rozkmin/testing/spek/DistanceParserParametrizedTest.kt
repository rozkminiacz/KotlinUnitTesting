package me.rozkmin.testing.spek

import me.rozkmin.testing.application.DistanceConverter
import me.rozkmin.testing.application.Kilometer
import me.rozkmin.testing.application.Meter
import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class DistanceParserParametrizedTest : Spek({
    describe("distance parser") {

        val distanceConverter = DistanceConverter()

        listOf(Input(500, 0.5), Input(750, 0.8))
                .forEach { input ->
                    it("meters ${input.parameter} should parse to ${input.expected}") {
                        assertEquals(input.expected, distanceConverter.parse(input.parameter))
                    }
                }

    }
})

data class Input(val parameter: Meter, val expected: Kilometer)
