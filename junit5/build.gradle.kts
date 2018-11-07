import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    kotlin("jvm")
}

dependencies {
    implementation(project(":application"))
    testCompile(Libs.junit_jupiter_api)
    testCompile(Libs.junit_jupiter_params)
    testRuntime(Libs.junit_jupiter_engine)
}

// GROOVY: test { ... }
tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        // GROOVY:
        // events "passed", "skipped", "failed"
        events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
    }
}
