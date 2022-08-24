

* build-image goal of spring-boot-maven-plugin plugin can be executed to build docker image for the application.

* As an other option, the image can be built using Dockerfile.

First build and package the application to create the jar file

mvn clean package

Then build docker image from the command prompt(change directory to the root of 
this project where Dockerfile resides)

cd springboot-examples\springboot-dockerization-example
docker build --tag=springboot-dockerization-example:1.0.0

Run the docker image

docker run -p8080:8080 springboot-dockerization-example:1.0.0

* You can also check for docker-maven-plugin of io.fabric8 or spotify docker plugin
as another option
  

After running the docker image test the following url:

http://localhost:8080