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

