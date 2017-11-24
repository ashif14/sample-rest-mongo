# Springboot CRUD Rest Api with MongoDB
This is a sample appliction for springboot employee management api with Mongodb
Following Methods available:
1.  GET /api/getEmployees -  Get all employee details
2.  GET /api/getEmployee/{employee_id} - Get specific employee detail.
3.  POST /api/createEmployee with data - Add New Employee to MongoDB
4.  PUT /api/updateEmployee/{employee_id} with data- Update existing employee
5.  DELETE /api/deleteEmployee/{employee_id} - Remove employee details from MongoDB.

This sample also integrates Swagger-UI at http://host:port/swagger-ui.html


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
