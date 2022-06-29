plugins {
    id("com.example.java")
}

interface ApplicationConvention {
    @get:Input
    val mainClass: Property<String>
}

extensions.create<ApplicationConvention>("application")