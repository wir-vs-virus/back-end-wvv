# wirvsvuris

https://wirvsvirushackathon.org/

## Run locally

Execute `scripts/runLocal.sh` to start the app with an h2 database started. h2 will persist the data in your `~/tmp` directory.

## Build Docker Image

In case you have jdk11 or higher installed build the project locally with `mvn clean install` or `mvn clean package`. After that execute `scripts/buildImage.sh`.
In case you don't have jdk11 or higher please build the Dockerfile located in `scripts/`, e.g. `docker build -t floge77/back-end-wvv -f scripts/Dockerfile_with_mvn_build .`.

## Run Docker Container

After you built the docker image run the container as follows: `scripts/runContainer.sh path/to/your/application-config-dir active-spring-profile`, e.g. `scripts/runContainer.sh $HOME/spring/config dev`.
