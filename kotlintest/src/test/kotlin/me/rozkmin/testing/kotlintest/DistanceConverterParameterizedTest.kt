package me.rozkmin.testing.kotlintest

import io.kotlintest.forAll
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
    val testCases = listOf(
      500L to 0.5,
      750L to 0.8
    )

    forAll(testCases) { (meter, kilometer) ->
      meter.toKilometer() shouldBe kilometer
    }
  }


})