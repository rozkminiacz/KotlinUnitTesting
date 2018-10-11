import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.2.71"))
    }
}

plugins {
    id("jmfayard.github.io.gradle-kotlin-dsl-libs") version "0.2.3"
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
}

