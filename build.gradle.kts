import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    `maven-publish`
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

repositories {
    mavenLocal()
    jcenter()
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.destroystokyo.paper:paper-api:1.16.4-R0.1-SNAPSHOT")
    implementation("com.github.ForgottenWorld.MCCoroutine:mccoroutine-bukkit-api:v0.0.7")
    implementation("com.github.ForgottenWorld.MCCoroutine:mccoroutine-bukkit-core:v0.0.7")
    implementation("io.github.rybalkinsd:kohttp:0.12.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.10")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
}

group = "it.forgottenworld"
version = "0.0.5"
description = "FWKotlinDeps"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

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
