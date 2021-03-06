# DVD Rental API's

Used technologies
1. Java
2. Spring boot
3. jooq framework
4. Springdata jpa
5. postgres

## Gradle setting 
Here we need to do additional settings in-order to support jooq plugin 
```java
plugins {
	id 'org.springframework.boot' version "2.2.4.RELEASE"
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
	id 'nu.studer.jooq' version '4.1'
}
def springfoxVersion = '3.0.0'
def springfoxUiVersion = '2.9.2'
group = 'com.ded.rental'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

repositories {
	mavenCentral()
}
jooq {
    generateSchemaSourceOnCompilation = false
    v1(sourceSets.main) {
        jdbc {
            driver = 'org.postgresql.Driver'
            url = 'jdbc:postgresql://localhost:5433/dvdrental'
            user = 'postgres'
            password = 'dece@123'
        }
        generator {
            database {
                name = 'org.jooq.meta.postgres.PostgresDatabase'
                inputSchema = 'dvdrental' //need to update schema
                outputSchemaToDefault = true
                excludes = "generate_sequence | sequence_range"
            }
            generate {
                relations = true
                deprecated = false
                records = false
                pojos = false
                fluentSetters = true
                javaTimeTypes = true
                validationAnnotations = false
            }
            target {
                packageName = 'com.model.rental'
                directory = 'src/main/java'
            }
        }
    }
    ```
}

dependencies {
	implementation "org.springframework.boot:spring-boot-starter-jooq"
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
    implementation group: 'org.postgresql', name: 'postgresql', version: '42.3.1'
 	jooqRuntime "org.postgresql:postgresql:42.3.1"
 	implementation 'org.springframework.boot:spring-boot-starter-web'
 	implementation "org.springframework.boot:spring-boot-starter-jdbc"
 	
}

test {
	useJUnitPlatform()
}
