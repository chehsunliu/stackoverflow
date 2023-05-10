plugins {
    kotlin("jvm") version "1.5.0"

    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.example.app"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    create("intTest") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
    create("e2eTest") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
}

val intTestImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.implementation.get())
}

val e2eTestImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.implementation.get())
}

configurations["intTestImplementation"].extendsFrom(configurations.runtimeOnly.get())
configurations["e2eTestImplementation"].extendsFrom(configurations.runtimeOnly.get())

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation(platform("org.junit:junit-bom:5.7.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    intTestImplementation(platform("org.junit:junit-bom:5.7.2"))
    intTestImplementation("org.junit.jupiter:junit-jupiter")
    intTestImplementation("org.springframework.boot:spring-boot-starter-test")

    e2eTestImplementation(platform("org.junit:junit-bom:5.7.2"))
    e2eTestImplementation("org.junit.jupiter:junit-jupiter")
    e2eTestImplementation("org.springframework.boot:spring-boot-starter-test")
}

val integrationTest = task<Test>("integrationTest") {
    description = "Runs integration tests."
    group = "verification"

    testClassesDirs = sourceSets["intTest"].output.classesDirs
    classpath = sourceSets["intTest"].runtimeClasspath
    shouldRunAfter("test")
}

val end2endTest = task<Test>("end2endTest") {
    description = "Runs end-to-end tests."
    group = "verification"

    testClassesDirs = sourceSets["e2eTest"].output.classesDirs
    classpath = sourceSets["e2eTest"].runtimeClasspath
    shouldRunAfter("test")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("spring.profiles.active", "test")
}

tasks.getByName<Test>("integrationTest") {
    useJUnitPlatform()
    systemProperty("spring.profiles.active", "integration")
}

tasks.getByName<Test>("end2endTest") {
    useJUnitPlatform()
    systemProperty("spring.profiles.active", "e2e")
}

tasks.check {
    dependsOn(integrationTest)
    dependsOn(end2endTest)
}
