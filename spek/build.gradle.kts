plugins {
    java
    kotlin("jvm")
}

dependencies {
    implementation(project(":application"))
    testImplementation(Libs.spek_dsl_jvm)  {
        exclude("org.jetbrains.kotlin")
    }
    testRuntimeOnly(Libs.spek_runner_junit5) {
        exclude("org.junit.platform")
        exclude("org.jetbrains.kotlin")
    }

    testCompile(Libs.junit_jupiter_api)


    // spek requires kotlin-reflect, can be omitted if already in the classpath
    testRuntimeOnly(Libs.kotlin_reflect)
}

repositories {
    maven {
        setUrl("https://dl.bintray.com/spekframework/spek-dev")
    }
}


tasks.withType<Test>().configureEach {
    this.useJUnitPlatform {
        includeEngines("spek2")
    }
}