plugins {
    java
    kotlin("jvm")
}

dependencies {
    implementation(project(":application"))
    compile(Libs.kotlin_stdlib_jdk8)
    testCompile(Libs.junit)
}