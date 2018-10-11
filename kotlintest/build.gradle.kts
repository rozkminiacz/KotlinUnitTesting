plugins {
    java
    kotlin("jvm")
}
group = "me.rozkmin.testing"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":application"))
    testCompile(Libs.kotlintest_runner_junit5)
}



//test {
//    useJUnitPlatform()
//}
tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}