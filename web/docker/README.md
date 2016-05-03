# How to deploy an application using Docker

1. Build project using maven and copy web-{version}.war to docker directory as ROOT.war
2. Build mysql docker with root password and empty database by executing following command
   <br>`docker build -t db -f Dockerfile-db .`
3. Build tomcat docker and copy WAR file into the docker container by executing following command
   <br>`docker build -t app -f Dockerfile-app .`
4. Run mysql docker
   <br>`docker run -it  db --name database`
5. Run tomcat docker with linking to database container
   <br>`docker run -it --link database:localhost -p 8181:8080 app`

Application deployed successfully.

You can access application at http://localhost:8181/app  # You can change port 8181 to 8080 too.

We can make this it easy using Docker Compose.(Work in progress :) ) 
