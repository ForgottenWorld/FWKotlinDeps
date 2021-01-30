import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    maven
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.serialization") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("com.github.ben-manes.versions") version "0.36.0"
}

repositories {
    jcenter()
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    implementation("io.github.rybalkinsd:kohttp:0.12.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.21")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
    implementation("com.charleskorn.kaml:kaml:0.26.0")
    implementation("org.koin:koin-core:2.2.2")
    implementation("com.github.BrunoSilvaFreire:Skedule:0.1.3")

}

group = "it.forgottenworld"
version = "0.0.8"
description = "FWKotlinDeps"
java.sourceCompatibility = JavaVersion.VERSION_1_8

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
