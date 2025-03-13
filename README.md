                                                 Person Recommendation System
A simple Spring Boot application that recommends users based on specific criteria like gender, age, and shared interests. This system is designed to be used as part of a dating application, where users can find potential matches based on common interests and the opposite gender.

        Features
Add Users: Register new users with basic information (name, age, gender, and interests).

Get Recommendations:
By User ID: Get top N recommendations based on the user's ID.
By User Name: Get top N recommendations based on the user's name.

Update Users: Modify a user's details (name, age, gender, interests).

Delete Users: Remove a user from the system.

        Technologies Used

Spring Boot: The application is built using Spring Boot, providing a robust framework for web development.

Spring Data JPA: For easy database interaction and management of user data.

MySQL: Used as the relational database for storing user details.

Lombok: Used for reducing boilerplate code in the model classes.

REST API: Exposes endpoints for user management and recommendations.

        Database Configuration
        
The system uses MySQL as the database.

Spring Data JPA is configured to connect to the MySQL database.

You must configure the database URL, username, and password in the application.properties file.

   spring.datasource.url=jdbc:mysql://localhost:3306/datingdb

   spring.datasource.username=root

   spring.datasource.password=root

   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver


   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

   spring.jpa.hibernate.ddl-auto=update

   spring.jpa.show-sql=true

   spring.jpa.properties.hibernate.format_sql=true

