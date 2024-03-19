plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.emobg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val koinVersion = "3.2.2"
val ktorVersion = "2.3.9"
var slf4jApiVersion = "2.0.12"
var slf4jReload4jVersion = "2.0.12"

dependencies {
    implementation("io.insert-koin:koin-core-jvm:$koinVersion")
    implementation ("io.insert-koin:koin-ktor:$koinVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("org.slf4j:slf4j-api:$slf4jApiVersion")
    implementation("org.slf4j:slf4j-reload4j:$slf4jReload4jVersion")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}