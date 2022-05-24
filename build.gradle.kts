import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.6.21"
	application
}

group = "me.victorpiles"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.junit.jupiter:junit-jupiter:5.8.1")
	testImplementation(kotlin("test"))
	implementation("commons-cli:commons-cli:1.5.0")
}

tasks.test {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}

application {
	mainClass.set("MainKt")
}