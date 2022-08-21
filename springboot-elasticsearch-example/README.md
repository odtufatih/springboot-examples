docker-compose.yml file is located under springboot-elasticsearch-example\src\main\resources path.

To start up elasticsearch as a local docker container:

docker-compose -f docker-compose.yml up -d

This command downloads the official elasticsearch image from dockerhub and
starts the elasticsearch container exposing port to 9200.

After the elasticsearch container and spring boot application is started, 
books index will be created and some dummy documents will be saved under this index.

Following elasticsearch urls may be checked to see the details of the index and the document with id 1.

* http://localhost:9200/books/
* http://localhost:9200/books/_doc/1

Following urls may be checked to test the spring boot application

* http://localhost:8080/books
* http://localhost:8080/books/1
* http://localhost:8080/books/search/Jack?page=0&&size=1

