# spring-boot-3-cloud-microservices

Clone this repository:

```bash
git clone https://github.com/deepaksorthiya/spring-boot-3-microservice.git
cd spring-boot-3-microservice
```

Start Docker:

```bash
docker compose up
```

This will get a copy of the project installed locally. Open the project in your IDE and update `src/main/resources/application.properties` with the following key-value pairs:

```properties
server.port=8888
spring.cloud.config.server.native.search-locations=/path/to/config/folder
```

The property `spring.cloud.config.server.native.search-locations` is the location where you store your configuration files. **Replace the value with a folder on your filesystem where these files will be saved.** For example, `file://${user.home}/config`.

Normally your configuration files would be stored in a remote location, for example, a GitHub repository or an Amazon S3 bucket. For instructions on how to store your config files in a git repository, see [this section in the Spring Cloud Config documentation](https://cloud.spring.io/spring-cloud-config/reference/html/#_git_backend). To keep this tutorial simple, you will use the "native" filesystem option above.

Start All Services:

```bash
mvn spring-boot:run
```