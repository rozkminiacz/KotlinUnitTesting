import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    kotlin("jvm")
}
group = "me.rozkmin.testing"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":application"))
    testCompile(Libs.junit_jupiter_api)
    testCompile(Libs.junit_jupiter_params)
    testRuntime(Libs.junit_jupiter_engine)
}

// GROOVY: test { ... }
tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    testLogging {
        // GROOVY:
        // events "passed", "skipped", "failed"
        events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
    }
}
