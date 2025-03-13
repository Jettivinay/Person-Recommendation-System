**Person Recommendation System**

----
A simple Spring Boot application that recommends users based on specific criteria like gender, age, and shared interests. This system is designed to be used as part of a dating application, where users can find potential matches based on common interests and the opposite gender.

**Features**
---------
**Add Users:** Register new users with basic information (name, age, gender, and interests).

**Get Recommendations:**
**By User ID:** Get top N recommendations based on the user's ID.
**By User Name:** Get top N recommendations based on the user's name.

**Update Users:** Modify a user's details (name, age, gender, interests).

**Delete Users:** Remove a user from the system.

**Technologies Used**
-----------

**Spring Boot:** The application is built using Spring Boot, providing a robust framework for web development.

**Spring Data JPA:** For easy database interaction and management of user data.

**MySQL:** Used as the relational database for storing user details.

**Lombok:** Used for reducing boilerplate code in the model classes.

**REST API:** Exposes endpoints for user management and recommendations.

**Database Configuration**
--------------
        
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

  **Endpoints**
  ---------------
**1. Add a New User**
   
URL: /api/users

Method: POST

**Request Body:**

{

  "name": "vinay",
  
  "age": 21,
  
  "gender": "male",
  
  "interests": ["music", "sports", "travel"]
  
}

**Response**: The newly added user.

**2. Get Recommendations by User ID**

**URL:** /api/users/{userId}/recommendations

**Method:** GET

**Query Parameters:**

**topN (Integer):** Number of recommended users to return.

**Response:** A list of recommended users based on gender, age, and common interests.

**3. Get Recommendations by User Name**
   
**URL: **/api/users/search

**Method:** GET

**Query Parameters:**

**name (String):** The name of the user to find.

**topN (Integer):** Number of recommended users to return.

**Response:** A list of recommended users.

**4. Update User Details**

**URL:** /api/users/{userId}

**Method:** PUT

**Request Body:**

{

  "name": "sweety",
  
  "age": 30,
  
  "gender": "female",
  
  "interests": ["reading", "music", "movies"]
  
}

Response: The updated user.

**5. Delete User**

**URL:** /api/users/{userId}

**Method:** DELETE

**Response:** A message indicating whether the deletion was successful or not.

  **Database Schema**
  ------------------
  
The application uses a MySQL database with the following schema:

**User Table:** Stores user information.

**User Interests Table:** Stores user interests in a separate table linked to the User table.

**Running the Application**
-----------
Clone the repository and navigate to the project directory.

Make sure you have MySQL running and the database (datingdb) is created.

Update the application.properties file with your database details.

Build and run the application:

bash -> mvn spring-boot:run

The application will be available at http://localhost:8081.

If you want to change the port_no goto the application.properties.file in that service.port:8081. You can change what you want. (like:8080 ,9092 etc.)

--------------------------------------------------
