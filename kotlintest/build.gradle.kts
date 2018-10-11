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

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


//test {
//    useJUnitPlatform()
//}
tasks.withType<Test>().configureEach {
    this.useJUnitPlatform()
}