# Kotlin Testing Examples

> All sample projects was verified under Gradle 4.8 and Intellij IDEA 2018.2.4

## Application
`UseCase` which provides empty string - to showcase structure of test methods

`DistanceConverter` - converts meters to kilometers in parameterized tests

## Junit4
### Attach to project
```groovy
dependencies{
    testCompile group: 'junit', name: 'junit', version: '4.12'
}
```

## Junit5
### Attach to project
```groovy
dependencies {
    testCompile('org.junit.jupiter:junit-jupiter-api:5.3.1')
    testCompile('org.junit.jupiter:junit-jupiter-params:5.3.1')
    testRuntime('org.junit.jupiter:junit-jupiter-engine:5.3.1')
}

test {
    useJUnitPlatform()
    testLogging {
        events "passed", "skipped", "failed"
    }
}
```

## KotlinTest
### Attach to project
```groovy
dependencies{
    testCompile 'io.kotlintest:kotlintest-runner-junit5:3.1.7'
}
```

## Spek
**version 2.x**
### Attach to project
```groovy
repositories {
    mavenCentral()
    maven { url "https://dl.bintray.com/spekframework/spek-dev" }

}

test {
    useJUnitPlatform {
        includeEngines 'spek2'
    }
}

dependencies {
    implementation project(':application')
    testImplementation ('org.spekframework.spek2:spek-dsl-jvm:2.0.0-alpha.1')  {
        exclude group: 'org.jetbrains.kotlin'
    }
    testRuntimeOnly ('org.spekframework.spek2:spek-runner-junit5:2.0.0-alpha.1') {
        exclude group: 'org.junit.platform'
        exclude group: 'org.jetbrains.kotlin'
    }

    testCompile('org.junit.jupiter:junit-jupiter-api:5.3.1')


    // spek requires kotlin-reflect, can be omitted if already in the classpath
    testRuntimeOnly "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"
}
```

### Plugin
You may also need Intellij or Android Studio [plugin](https://plugins.jetbrains.com/plugin/10915-spek-framework)