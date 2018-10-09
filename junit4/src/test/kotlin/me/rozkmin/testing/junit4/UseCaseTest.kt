package me.rozkmin.testing.junit4

import me.rozkmin.testing.application.UseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class UseCaseTest {
    @Test
    fun `it should return empty string`() {
        val useCase = UseCase()

        val actual = useCase.execute()
        val expected = ""

        assertEquals(expected, actual)
    }
}