# Restful Social Media Service
Restful Social Media Service with Spring Boot and MySQL

Run MySQL on Docker

docker run 
--detach 
--env MYSQL_ROOT_PASSWORD=dummypassword
--env MYSQL_USER=social-media-user 
--env MYSQL_PASSWORD=dummypassword 
--env MYSQL_DATABASE=social-media-database 
--name mysql 
--publish 3306:3306 mysql:8-oracle


http://localhost:8080/swagger-ui/index.html

![image](https://github.com/onurokkyay/RestfulSocialMediaService/assets/59628395/5683ea31-166d-4cb1-a6d4-9702381e4573)
