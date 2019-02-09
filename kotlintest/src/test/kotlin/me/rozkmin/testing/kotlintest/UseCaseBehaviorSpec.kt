package me.rozkmin.testing.kotlintest

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import me.rozkmin.testing.application.UseCase

class UseCaseBehaviorSpec: BehaviorSpec({
    Given("use case"){
        val useCase = UseCase()
        When("execute"){
            val output = useCase.execute()
            Then("return empty string"){
                output shouldBe ""
            }
        }
    }
})