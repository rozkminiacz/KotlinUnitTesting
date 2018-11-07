import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("jmfayard.github.io.gradle-kotlin-dsl-libs") version "0.2.6"
    `kotlin-dsl`
}


allprojects {

    group = "me.rozkmin.testing"
    version = "1.0-SNAPSHOT"

    repositories {
        jcenter()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    apply(plugin = "java")
    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

tasks.register("updateReadme") {
    description = "Update README.adoc with the versions number"
    group = "Custom"

    val README_VARIABLES = mapOf(
        "junit" to Versions.junit,
        "jupiter" to Versions.org_junit_jupiter,
        "kotlintest" to Versions.kotlintest_runner_junit5,
        "mockk" to Versions.mockk,
        "spek" to Versions.org_spekframework_spek2,
        "mockito" to Versions.mockito_core,
        "strikt" to Versions.strikt_core,
        "mockito_kotlin" to Versions.mockito_kotlin
    )

    doLast {
        println("== Copy-paste the content above in the top of README.adoc")
        println()
        println(":gradle: ${Versions.Gradle.currentVersion}")
        for ((variable, value) in README_VARIABLES) {
            println(":$variable: $value")
        }

    }
}
