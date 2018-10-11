plugins {
    java
    kotlin("jvm")
}
group = "me.rozkmin.testing"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":application"))
    compile(Libs.org_jetbrains_kotlin_kotlin_stdlib_jdk8)
    testCompile(Libs.junit)
}