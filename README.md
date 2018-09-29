# Akka Starter Kit in Scala

Basic Boilerplate for Starting up your APIs in Scala.

Also, using Gradle, not sbt (Phew :relaxed:).

### Powered By 
<img src="https://raw.githubusercontent.com/OlegIlyenko/scala-icon/master/scala-icon.png" width="40"> <img src="https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/Akka_toolkit_logo.svg/1200px-Akka_toolkit_logo.svg.png" height="40"> <img src="https://cdn.freebiesupply.com/logos/large/2x/gradle-logo-png-transparent.png" width="40">

### Sample Routes
 - `/ping`
 - `/sample`
 - `/sample/get`
 - `/sample/post`
 - `/sample/combo`
 - `/sample/exception`

### Building with Docker
 - Run `sh build.sh` or use the docker build command `docker build . -t akka_starter` to build.

### Notes:
 - Ensure you have Scala plugin installed with Intellij.
 - Application depends on the env variable `ENVIRONMENT`.
 - By default the server runs on port 80 for production and 8080 for others.
