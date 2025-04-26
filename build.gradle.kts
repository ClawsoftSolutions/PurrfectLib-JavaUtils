plugins {
    id("java")
    id("maven-publish")
}

group = "com.github.clawsoftsolutions.purrfectlib"
version = "0.0.3"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.classgraph:classgraph:4.8.179")
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = "javautils"
        }
    }
    repositories {
        maven {
            name = "cloudsmith"
            url = uri("https://maven.cloudsmith.io/clawsoftsolutions/purffectlib/maven/")
            credentials {
                username = (findProperty("cloudsmith.user") as String?)
                    ?: System.getenv("CLOUDSMITH_USER")
                password = (findProperty("cloudsmith.apiKey") as String?)
                    ?: System.getenv("CLOUDSMITH_API_KEY")
            }
        }
    }
}
