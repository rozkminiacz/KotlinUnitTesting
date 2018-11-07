plugins {
    java
    kotlin("jvm")
}

dependencies {
    implementation(project(":application"))
    testCompile(Libs.kotlintest_runner_junit5)
}



//test {
//    useJUnitPlatform()
//}
tasks.withType<Test> {
    useJUnitPlatform()
}