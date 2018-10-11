package me.rozkmin.testing.kotlintest

import io.kotlintest.data.forall
import io.kotlintest.inspectors.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import me.rozkmin.testing.application.DistanceConverter
import me.rozkmin.testing.application.Kilometer
import me.rozkmin.testing.application.Meter


class DistanceConverterParameterizedTest : StringSpec({

  val converter = DistanceConverter()

  "Convert meter to kilometer" {
    val inputs = listOf(
      Input(500L, 0.5),
      Input(750L, 0.8)
    )

    fun Meter.toKilometer(): Kilometer =
      converter.parse(this)

    inputs.forAll { (meter, kilometer) ->
      meter.toKilometer() shouldBe kilometer
    }
  }


  // Alternative style, using the row(arg1, arg2, ...) syntax
  "check distance parse"{
    forall(
      row(500L, 0.5),
      row(750L, 0.8)
    ) { meter, kilometer ->
      converter.parse(meter) shouldBe kilometer
    }
  }


})


data class Input(val parameter: Meter, val expected: Kilometer)


