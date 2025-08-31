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

A modern **Spring Boot 3** microservice starter project featuring:

- Spring Cloud Config Server
- Netflix Eureka Discovery Service
- Spring Cloud Gateway
- Docker Compose integration
- Modular microservice architecture
- Distributed Tracing Using Zipkin

---

## 📦 Clone the Repository

```bash
git clone https://github.com/deepaksorthiya/spring-boot-3-microservice.git
cd spring-boot-3-microservice
```

---

## 🐳 Getting Started with Docker

Start all required docker services using Docker Compose:

```bash
docker compose up
```

---

## ⚙️ Configuration

Update the configuration service properties:

1. Open Config Server `spring-cloud-configuration-service/src/main/resources/application.properties`
2. Set/verify the following properties values:

```properties
server.port=8888
spring.cloud.config.server.native.search-locations=file:///${user.dir}/config-files-all
```

> **Note:**  
> For Windows OS configuration files are stored, e.g. `file:///${user.dir}/config-files-all` .
> On Windows, you need an extra "/" in the file URL if it is absolute with a drive prefix.
> For Linux/Mac-OS use `file://${user.dir}/config-files-all`

For advanced configuration (e.g., using Git or S3), refer to
the [Spring Cloud Config documentation](https://cloud.spring.io/spring-cloud-config/reference/html/#_git_backend).

---

## 🏁 Service Startup Order

Start the following services in order:

1. **spring-cloud-configuration-service**
2. **spring-cloud-netflix-discovery-service**
3. **spring-cloud-gateway-service**

Then start the remaining microservices:

All microservices are under ``spring-boot-api-microservices`` folder.

- **department-service**
- **employee-service**
- **organization-service**
- **service-one**

Use below command to run each services.

```bash
mvn spring-boot:run
```

---

## 🧪 API Testing

- Use the
  provided [Postman API Collection](https://www.postman.com/deepaksorthiya/workspace/public-ws/collection/12463530-603aa599-2c2e-4bd9-9537-84439c965cc3?action=share&creator=12463530&active-environment=12463530-55c10ebe-548f-4c1b-a5ec-4d4ed996c033)
  for testing endpoints.
- For distributed tracing
  check [http://localhost:9411/zipkin](http://localhost:9411/zipkin)
- Netflix Service Discovery  [http://localhost:8761](http://localhost:8761)

---

## 📚 Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/reference/html/)
- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)
- [Netflix Eureka](https://spring.io/projects/spring-cloud-netflix)