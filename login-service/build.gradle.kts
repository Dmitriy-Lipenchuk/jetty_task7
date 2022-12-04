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

    implementation("com.google.code.gson:gson:2.9.1")
}