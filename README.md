<h1 style="text-align: center;">Spring Boot Starter Microservice Project</h1>

<p style="text-align: center;">
  <a href="https://github.com/deepaksorthiya/spring-boot-3-microservice/workflows/maven.yml">
    <img src="https://github.com/deepaksorthiya/spring-boot-3-microservice/actions/workflows/maven.yml/badge.svg" alt="Java Maven Build Test"/>
  </a>
  <a href="https://hub.docker.com/r/deepaksorthiya/spring-boot-3-microservice">
    <img src="https://img.shields.io/docker/pulls/deepaksorthiya/spring-boot-3-microservice" alt="Docker"/>
  </a>
  <a href="https://spring.io/projects/spring-boot">
    <img src="https://img.shields.io/badge/spring--boot-3.5.5-brightgreen?logo=springboot" alt="Spring Boot"/>
  </a>
</p>

---

## 🚀 Overview

A modern **Spring Boot** Microservice starter project .

---

## Clone repository:

```bash
git clone https://github.com/deepaksorthiya/spring-boot-3-microservice.git
cd spring-boot-3-microservice
```

## Getting Start

Start Docker:

```bash
docker compose up
```

This will get a copy of the project installed locally. Open the project in your IDE and in *
*spring-cloud-configuration-service** update `src/main/resources/application.properties` with the following key-value
pairs:

```properties
server.port=8888
spring.cloud.config.server.native.search-locations=/path/to/config/folder
```

The property `spring.cloud.config.server.native.search-locations` is the location where you store your configuration
files. **Replace the value with a folder on your filesystem where these files will be saved.** For example,
`file://${user.home}/config`.

Normally your configuration files would be stored in a remote location, for example, a GitHub repository or an Amazon S3
bucket. For instructions on how to store your config files in a git repository,
see [this section in the Spring Cloud Config documentation](https://cloud.spring.io/spring-cloud-config/reference/html/#_git_backend).
To keep this tutorial simple, you will use the "native" filesystem option above.

## Start All Services In Given Order

1. spring-cloud-configuration-service
2. spring-cloud-netflix-discovery-service
3. spring-cloud-gateway-service

After this start remaining microservices.

```bash
mvn spring-boot:run
```

## Testing

[Postman API Collection](https://www.postman.com/deepaksorthiya/workspace/public-ws/collection/12463530-603aa599-2c2e-4bd9-9537-84439c965cc3?action=share&creator=12463530&active-environment=12463530-55c10ebe-548f-4c1b-a5ec-4d4ed996c033) 