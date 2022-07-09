plugins {
    base
    `jvm-ecosystem`
}

sourceSets {
    create(SourceSet.MAIN_SOURCE_SET_NAME) {
        java.srcDir("src/${SourceSet.MAIN_SOURCE_SET_NAME}/java")
        compileClasspath = configurations.maybeCreate(compileClasspathConfigurationName).apply {
            isVisible = false
            isCanBeResolved = true
            isCanBeConsumed = false
        }
    }

    create(SourceSet.TEST_SOURCE_SET_NAME) {
        java.srcDir("src/${SourceSet.TEST_SOURCE_SET_NAME}/java")
    }
}

val mainSourceSet: SourceSet = sourceSets.getByName(SourceSet.MAIN_SOURCE_SET_NAME)
val testSourceSet: SourceSet = sourceSets.getByName(SourceSet.TEST_SOURCE_SET_NAME)

configurations {
    create("implementation")
}

val compileJava = tasks.register<JavaCompile>(mainSourceSet.compileJavaTaskName) {
    source(mainSourceSet.java)
    classpath = mainSourceSet.compileClasspath
    destinationDirectory.set(layout.buildDirectory.dir("classes/${mainSourceSet.java.name}/${mainSourceSet.name}"))
}

val compileTestJava = tasks.register<JavaCompile>(testSourceSet.compileJavaTaskName) {
    source(testSourceSet.java)
    classpath = testSourceSet.compileClasspath
    destinationDirectory.set(layout.buildDirectory.dir("classes/${mainSourceSet.java.name}/${mainSourceSet.name}"))
}

tasks.build {
    dependsOn(compileJava, compileTestJava)
}
