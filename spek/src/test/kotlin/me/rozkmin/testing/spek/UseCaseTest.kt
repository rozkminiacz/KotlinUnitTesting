package me.rozkmin.testing.spek

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.junit.jupiter.api.Assertions.assertEquals
import me.rozkmin.testing.application.UseCase


object UseCaseTest : Spek({
    describe("use case") {
        val useCase = UseCase()
        it("should return empty string") {
            val actual = useCase.execute()
            val expected = ""
            assertEquals(expected, actual)
        }
    }
})