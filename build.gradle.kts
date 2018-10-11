import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("jmfayard.github.io.gradle-kotlin-dsl-libs") version "0.2.3"
    java
    `kotlin-dsl`
}

group = "me.rozkmin.testing"
version = "1.0-SNAPSHOT"

allprojects {


    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
    }

    apply(plugin = "java")
    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


}

