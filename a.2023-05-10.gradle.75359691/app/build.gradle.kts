plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":plugin"))
    implementation(project(":plugin-dog"))
    // implementation(project(":plugin-cat"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("io.github.chehsunliu.demo.App")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
