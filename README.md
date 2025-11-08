# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.8-SNAPSHOT/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.8-SNAPSHOT/gradle-plugin/packaging-oci-image.html)
* [Spring Session for Spring Data Redis](https://docs.spring.io/spring-session/reference/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

# Run first instance on port 8081
./gradlew bootRun --args='--server.port=8081'

# Open a new terminal
# Run second instance on port 8082
./gradlew bootRun --args='--server.port=8082'

# Open the browser 1 
# which sets the redis session with user token value
http://localhost:8081/session/set/token

# Open the Browser 2
# in the broswer tab2 it retrive the session token set by the /set api
http://localhost:8082/session/get
