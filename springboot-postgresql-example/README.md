
To start up postgresql as a local docker container:

docker-compose -f docker-compose.yml up -d

This command downloads the official latest postgresql image from dockerhub and
starts the docker container exposing port to 5432. 

Adminer application runs at http://localhost:8080 and provides a db interface.
You can login with the following credentials.

Application/Sunucu:db
User/Kullanıcı:postgres
Parola:****

