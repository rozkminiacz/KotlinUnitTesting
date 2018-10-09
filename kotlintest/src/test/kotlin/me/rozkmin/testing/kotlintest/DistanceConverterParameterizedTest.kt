package me.rozkmin.testing.kotlintest

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import me.rozkmin.testing.application.DistanceConverter
import me.rozkmin.testing.application.Kilometer
import me.rozkmin.testing.application.Meter

class DistanceConverterParameterizedTest : StringSpec({

    val distanceConverter = DistanceConverter()

    "check distance parse"{
        forall(
                row(Input(500, 0.5)),
                row(Input(750, 0.8))
        ) {
            distanceConverter.parse(it.parameter) shouldBe it.expected
        }
    }
})

data class Input(val parameter: Meter, val expected: Kilometer)
