plugins {
    application
}

group = "ru.gamesphere"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("ru.gamesphere.Main")
}

dependencies {
    implementation(project(":db-utils"))

    implementation("com.google.code.gson:gson:2.10")

    implementation("org.jboss.resteasy:resteasy-guice:4.7.7.Final")
    implementation("org.jboss.resteasy:resteasy-jackson2-provider:6.2.1.Final")

    implementation("jakarta.ws.rs:jakarta.ws.rs-api:3.1.0")

    implementation("javax:javaee-api:8.0")
}