# Project Organizer Database Access - Pair Exercise

**Setup:** 

* Create a PostgreSQL database called **projects**: _```createdb -U postgres projects```_

* Create a Database Connection to the **projects** database in dbVisualizer.

* Run the `projects.sql` in the database folder to create and populate the tables of this exercise.

You will need to query the project database tables to determine what the correct result should be for each process in the application program.  ie. YOU are expected to know if the data displayed is correct. Do not assume it is correct. KNOW it is correct.
<br/>

## Part 1 (Day 1 - Monday) - Data Access Objects

Complete the CLI application for the project database by implementing the `JDBCDepartmentDAO`, `JDBCEmployeeDAO`, and `JDBCProjectDAO`.

The CLI application program works and should not be changed.

The model/class and interface for each table is  provided.

Skeleton code for each JDBC/DAO is provided. You are expected to complete the JDBC-DAO methods to provide the processing and return value indicated by the interface.

The application program should run successfully and display the data from the tables based on the menu selections.

Consider testing the SQL queries you write in dbVisualizer before putting them in the DAO to be sure they produce the result you expect.

You will need to query the project database tables to determine what the correct result should be for each process in the application program.  ie. YOU are expected to know if the data displayed is correct. Do not assume it is correct. KNOW it is correct.

<br/>

---
## Part 2 (Day 2 - Tuesday) - Integration Testing

Create a Unit Test project for the **Project Organizer Database** application. Implement integration tests for the `JDBCDepartmentDAO`, `JDBCEmployeeDAO`, and `JDBCProjectDAO` classes.

Be sure to clean up any test data so that the database is returned to its original state after the test is completed.
