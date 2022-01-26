#Music Album Archive Service

A spring boot application which exposes two RestEndpoints to GET/SET Album Details

### <U>There are below 2 functionalities implemented as part of this task</U>
```
1. Add the new Music Album

2. Fetch all the Music Album from repository
```

### <U>Installation</U>

The application is built using gradle and all the dependencies will be added automatically

####Build the application:
```
gradle build
```

For Running Application in local:
```
$ gradle bootrun

```

For Running Application in Docker
```
Create Docker image using below Docker command in the Terminal
docker build --tag musicAlbumArchive-docker .

Start the application in the Docker image using the below command
docker run -dp 8080:8080 musicAlbumArchive-docker

```


#### Use PostMan to test the application using the below API endpoint:

```
http://localhost:8080/api/musicAlbumsArchive
```