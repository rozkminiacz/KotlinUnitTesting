plugins {
  application
  kotlin("jvm")
}

dependencies {
  compile(Libs.kotlin_stdlib_jdk8)
  implementation(project(":application"))
  testCompile(Libs.junit)
  testCompile(Libs.mockk)
}
