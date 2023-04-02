plugins {
    kotlin("jvm") version "1.8.0"
    application

    // id("java")
    id("idea")
    id("com.google.protobuf") version "0.9.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val kotestVersion = "5.5.5"
val grpcVersion = "1.15.1"
val protobufVersion = "3.22.2"
dependencies {
    testImplementation(kotlin("test"))

    implementation("com.github.ajalt.clikt:clikt:3.5.2")

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")

    implementation("com.google.protobuf:protobuf-java:$protobufVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}

protobuf {
    protoc {
        // The artifact spec for the Protobuf Compiler
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }
    // plugins {
    //     // Optional: an artifact spec for a protoc plugin, with "grpc" as
    //     // the identifier, which can be referred to in the "plugins"
    //     // container of the "generateProtoTasks" closure.
    //     id("grpc") {
    //         artifact = "io.grpc:protoc-gen-grpc-java:1.15.1"
    //     }
    // }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                // Apply the "grpc" plugin whose spec is defined above, without
                // options. Note the braces cannot be omitted, otherwise the
                // plugin will not be added. This is because of the implicit way
                // NamedDomainObjectContainer binds the methods.
                // id("grpc") { }
            }
        }
    }
}
