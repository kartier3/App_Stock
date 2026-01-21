plugins {
    kotlin("jvm") version "2.0.10"
    id("org.jetbrains.dokka") version "1.9.20"
    jacoco
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("io.github.oshai:kotlin-logging-jvm:7.0.0")
    implementation("org.slf4j:slf4j-simple:2.0.16")

    implementation("com.thoughtworks.xstream:xstream:1.4.18")
    implementation("org.codehaus.jettison:jettison:1.4.1")

}

tasks.test {
    useJUnitPlatform()

}


kotlin {
    jvmToolchain(16)
}



tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    // for building a fat jar - include all dependencies
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get()
            .filter { it.name.endsWith("jar") }
            .map { zipTree(it) }
    })
}

