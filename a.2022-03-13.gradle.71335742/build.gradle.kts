import com.github.chehsunliu.example.GreetingTask

buildscript {
    dependencies {
        classpath("com.github.chehsunliu.example:q71335742-plugin")
    }
}

tasks.register<GreetingTask>("greeting")
