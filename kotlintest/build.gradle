group 'me.rozkmin.testing'
version '1.0-SNAPSHOT'

apply plugin: 'java'
apply plugin: 'kotlin'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

test {
    useJUnitPlatform()
}

dependencies {
    implementation project(':application')
    testCompile 'io.kotlintest:kotlintest-runner-junit5:3.1.7'
}

compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}
compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}