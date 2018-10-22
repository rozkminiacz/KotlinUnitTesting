plugins {
    application
    kotlin("jvm")
}
group = "me.rozkmin.testing"
version = "1.0-SNAPSHOT"

dependencies {
    compile(Libs.kotlin_stdlib_jdk8)
    testCompile(Libs.junit)
}

