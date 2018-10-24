import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    application
    kotlin("jvm")
}

dependencies {
    compile(Libs.kotlin_stdlib_jdk8)
    implementation(project(":application"))

    testCompile(Libs.junit_jupiter_api)
    testCompile(Libs.junit_jupiter_params)
    testRuntime(Libs.junit_jupiter_engine)
    testImplementation(Libs.strikt_core)

}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    testLogging {
        events = setOf(PASSED, SKIPPED, FAILED)
    }
}
