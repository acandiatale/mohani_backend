plugins {
    java
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "kr.co.mohani"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // oracle cloud db
    runtimeOnly("com.oracle.database.jdbc:ojdbc8:21.8.0.0")
    implementation("com.oracle.database.security:osdt_cert:21.8.0.0")
    implementation("com.oracle.database.security:osdt_core:21.8.0.0")
    implementation("com.oracle.database.security:oraclepki:21.8.0.0")

    // https://mvnrepository.com/artifact/org.javassist/javassist
    implementation("org.javassist:javassist:3.29.2-GA")


    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//tasks.register<JavaExec>("runWithJavaExec") {
//    description = "Runnable jar file to build"
//    main = "kr.co.mohani.mohani_server.MohaniServerApplication"
//    classpath = sourceSets["main"].runtimeClasspath
//}