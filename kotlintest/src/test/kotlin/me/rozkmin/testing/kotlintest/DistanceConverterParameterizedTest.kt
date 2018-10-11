package me.rozkmin.testing.kotlintest

import io.kotlintest.inspectors.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import me.rozkmin.testing.application.DistanceConverter
import me.rozkmin.testing.application.Kilometer
import me.rozkmin.testing.application.Meter


class DistanceConverterParameterizedTest : StringSpec({

  val converter = DistanceConverter()

  fun Meter.toKilometer(): Kilometer =
    converter.parse(this)

  "Convert meter to kilometer" {
    val inputs = listOf(
      Input(500L, 0.5),
      Input(750L, 0.8)
    )

    inputs.forAll { (meter, kilometer) ->
      meter.toKilometer() shouldBe kilometer
    }
  }


})


data class Input(val parameter: Meter, val expected: Kilometer)


