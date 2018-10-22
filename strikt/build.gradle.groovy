group 'me.rozkmin.testing'
version '1.0-SNAPSHOT'

apply plugin: 'java'
apply plugin: 'kotlin'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation project(':application')
    testCompile('org.junit.jupiter:junit-jupiter-api:5.3.1')
    testCompile('org.junit.jupiter:junit-jupiter-params:5.3.1')
    testRuntime('org.junit.jupiter:junit-jupiter-engine:5.3.1')
    testImplementation("io.strikt:strikt-core:0.16.0")

}

test {
    useJUnitPlatform()
    testLogging {
        events "passed", "skipped", "failed"
    }
}

compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}
compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}