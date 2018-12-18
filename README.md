# Spring boot + Quartz + JPA + Sqlite3 Example

This project is an example for running Quartz jobs with Spring boot.
The application uses JPA to access Sqlite3 and injects JPA repositories into Quartz jobs.

## How to run
You need to create a database file demo.db for Sqlite3 first.
- Use create_tables.sql under misc folder to create tables.
- Put demo.db under the root of this application. 
Now you can start the application in a few ways, but the easiest way is by using Maven.
- $mvn spring-boot:run

This application will run SampleJob.java to retrieve data from Sqlite3 each 5secs.