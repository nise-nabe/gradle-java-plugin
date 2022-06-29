plugins {
    base
    `jvm-ecosystem`
}

sourceSets {
    create(SourceSet.MAIN_SOURCE_SET_NAME)
}

configurations {
    create("implementation")
}