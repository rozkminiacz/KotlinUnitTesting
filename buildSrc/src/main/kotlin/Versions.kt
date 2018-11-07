import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew syncLibs`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val mockito_kotlin: String = "2.0.0-RC1" 
            /* Could not find any version that matches com.nhaarman.mockitokotlin2:mockito-kotlin:+.
            Versions rejected by component selection rules: 2.0.0-alpha03
            Searched in the following locations: https://jcenter.bintray.com/com/nhaarman/mockitokotlin2/mockito-kotlin/maven-metadata.xml 
            .... */

    const val kotlintest_runner_junit5: String = "3.1.7" //available: "3.1.10" 

    const val mockk: String = "1.8.9" //available: "1.8.12" 

    const val strikt_core: String = "0.16.0" //available: "0.17.0" 

    const val jmfayard_github_io_gradle_kotlin_dsl_libs_gradle_plugin: String = "0.2.6" 

    const val junit: String = "4.12" 

    const val org_gradle_kotlin_kotlin_dsl_gradle_plugin: String = "1.0-rc-5" //available: "1.0" 

    const val kotlin_reflect: String = "1.2.71" //available: "1.3.0" 

    const val kotlin_sam_with_receiver: String = "1.2.61" //available: "1.3.0" 

    const val kotlin_scripting_compiler_embeddable: String = "1.2.61" //available: "1.3.0" 

    const val kotlin_stdlib_jdk8: String = "1.2.71" //available: "1.3.0" 

    const val org_junit_jupiter: String = "5.3.1" 

    const val mockito_core: String = "2.23.0" 

    const val org_spekframework_spek2: String = "2.0.0-alpha.1" 
            /* Could not find any version that matches org.spekframework.spek2:spek-dsl-jvm:+.
            Versions rejected by component selection rules:
              - 2.0.0-rc.1
              - 2.0.0-alpha.2 
            .... */

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "4.10.2"

        const val currentVersion: String = "4.10.2"

        const val nightlyVersion: String = "5.1-20181107000023+0000"

        const val releaseCandidate: String = "5.0-rc-1"
    }
}
