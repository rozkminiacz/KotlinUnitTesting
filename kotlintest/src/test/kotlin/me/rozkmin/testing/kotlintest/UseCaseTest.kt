package me.rozkmin.testing.kotlintest

import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import me.rozkmin.testing.application.UseCase


class UseCaseTest : WordSpec({
    "use case" should {
        val useCase = UseCase()
        "return empty string"{
            val actual = useCase.execute()
            val expected = ""

            expected shouldBe actual
        }
    }
})