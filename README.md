# Springboot CRUD Rest Api with MongoDB
This is a sample appliction for springboot api with Mongodb


# Prequisites
1.  Have Maven downloded and is in Path.
2.  Java 7+
3.  MongoDB Installled.

# How to run this sample
1.  Download and extract this project.
2.  Start MongoDB with 
    ```
    mongod --dbpath data_directory_path
    ```
3.  Change your MongoDb configuration in src/java/resource/application.properties
4.  Go to CMD and run 
    
    ```
    mvn spring-boot:run
    ```
4.  Go to browser type http://localhost:8080/swagger-ui.html
