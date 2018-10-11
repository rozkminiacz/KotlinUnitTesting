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
