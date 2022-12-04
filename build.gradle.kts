plugins {
    id("java")
    id("nu.studer.jooq") version "8.0" apply false
}

group = "ru.gamesphere"
version = "1.0-SNAPSHOT"

subprojects  {
    repositories {
        mavenCentral()
    }

    apply {
        plugin ("java")
        plugin("nu.studer.jooq")
    }

    dependencies {
        implementation("org.jetbrains:annotations:23.0.0")

        implementation("org.jooq:jooq:3.17.4")
        implementation("org.jooq:jooq-codegen:3.17.4")
        implementation("org.jooq:jooq-meta:3.17.4")

        implementation("com.google.inject:guice:5.1.0")
        implementation("com.google.inject.extensions:guice-servlet:5.1.0")

        implementation("com.fasterxml.jackson.core:jackson-core:2.14.1")

        implementation("org.eclipse.jetty:jetty-server:9.4.33.v20201020")
        implementation("org.eclipse.jetty:jetty-servlet:9.4.33.v20201020")
        implementation("org.eclipse.jetty:jetty-servlets:9.4.33.v20201020")
    }
}