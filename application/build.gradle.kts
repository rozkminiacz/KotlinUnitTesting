plugins {
    application
    kotlin("jvm")
}
group = "me.rozkmin.testing"
version = "1.0-SNAPSHOT"

dependencies {
    compile(Libs.org_jetbrains_kotlin_kotlin_stdlib_jdk8)
    testCompile(Libs.junit)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
