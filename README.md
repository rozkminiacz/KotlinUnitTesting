# Kotlin Unit Testing Examples

This repository contains examples of basic unit tests written in Kotlin. In specific directories you can find gradle buildscript with needed dependencies and configuration, simple unit test and parameterized test. 

> All sample projects was verified under Gradle 4.8 and Intellij IDEA 2018.2.4

## Application
`UseCase` which provides empty string - to showcase structure of test methods

`DistanceConverter` - converts meters to kilometers in parameterized tests

`MVP` - Model-View-Presenter contract

## Junit4
[https://junit.org/junit4/](https://junit.org/junit4/)
### Attach to project
```groovy
dependencies{
    testCompile group: 'junit', name: 'junit', version: '4.12'
}
```

## Junit5
[https://junit.org/junit5/](https://junit.org/junit5/)
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
[https://github.com/kotlintest/kotlintest](https://github.com/kotlintest/kotlintest)
### Attach to project
```groovy
dependencies{
    testCompile 'io.kotlintest:kotlintest-runner-junit5:3.1.7'
}
```

## Spek
[https://spekframework.org](https://spekframework.org)
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
> For Spek you may also need additional Intellij or Android Studio [plugin](https://plugins.jetbrains.com/plugin/10915-spek-framework)

## Mockito
[https://site.mockito.org](https://site.mockito.org)

### Attach to project
```groovy
repositories {
    mavenCentral()
    jcenter()
}


dependencies {
    testCompile "org.mockito:mockito-core:2.23.0"
    
    testCompile group: 'junit', name: 'junit', version: '4.12'
}
```

## Mockito-Kotlin
[https://github.com/nhaarman/mockito-kotlin](https://github.com/nhaarman/mockito-kotlin)

### Attach to project
```groovy
repositories {
    mavenCentral()
    jcenter()
}


dependencies {
    testCompile "org.mockito:mockito-core:2.23.0"
    testCompile "com.nhaarman.mockitokotlin2:mockito-kotlin:2.0.0-RC1"
    
    testCompile group: 'junit', name: 'junit', version: '4.12'
}
```

## Mockk
[https://github.com/mockk/mockk](https://github.com/mockk/mockk)

### Attach to project
```groovy
dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    testImplementation "io.mockk:mockk:1.8.9"
}
```


## Strikt
[https://strikt.io](https://strikt.io)
### Attach to project
```groovy
dependencies {
    testImplementation("io.strikt:strikt-core:0.16.0")
}
```
