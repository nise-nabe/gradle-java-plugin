import org.gradle.api.internal.artifacts.JavaEcosystemSupport

plugins {
   `jvm-test-suite`
}

sourceSets {
    create(SourceSet.MAIN_SOURCE_SET_NAME)
}

val schema = project.dependencies.attributesSchema
JavaEcosystemSupport.configureSchema(schema, objects)

@Suppress("UNUSED_VARIABLE")
testing {
    suites {
        // Configure the built-in test suite
        val test by creating(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.8.1")
        }
    }
}