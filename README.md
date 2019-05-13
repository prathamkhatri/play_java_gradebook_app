# Gradebook App using the Play! framework for Java
This project is the final project for ICSI 410 Introduction to Databases

A Simple CRUD application for a gradebook app. Admins can perform all kinds CRUD task while student mode can only read the data.
Password and username for the admin is set as 'admin'.

Prerequisites include:

* Java Software Developer's Kit (SE) 1.8 or higher
* sbt 0.13.15 or higher (we recommend 1.2.3) Note: if you downloaded this project as a zip file from https://developer.lightbend.com, the file includes an sbt distribution for your convenience.
* MYSQL8

To check your Java version, enter the following in a command window:

`java -version`

To check your sbt version, enter the following in a command window:

`sbt sbtVersion`

If you do not have the required versions, follow these links to obtain them:

* [Java SE](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [sbt](http://www.scala-sbt.org/download.html)

## Before building the project

This application requires you to have MYSQL8. In config/configuration.conf, the configuration for MYSQL database is written. Changes can be made to username and passord. The default password and username is set to as 'root'. Once you setup the configuration file, go to your MYSQL and run the following MYSQL script:

create database gradebook;

use gradebook;

create table grade ( id integer auto_increment not null, title varchar(255), score double not null, student varchar(255), professor varchar(255), classroom varchar(255), semester varchar(255), major varchar(255), constraint pk_grade primary key (id));



## Build and run the project

This example Play project was created from a seed template. It includes all Play components and an Akka HTTP server. The project is also configured with filters for Cross-Site Request Forgery (CSRF) protection and security headers.

To build and run the project:

1. Use a command window to change into the example project directory, for example: `cd play_java_gradebook_app`

2. Build the project. Enter: `sbt run`. The project builds and starts the embedded HTTP server. Since this downloads libraries and dependencies, the amount of time required depends partly on your connection's speed.

3. After the message `Server started, ...` displays, enter the following URL in a browser: <http://localhost:9000>

4. Play will try to create the table 'grade' for the user, however, we had to disable this option since we are required to create tables manually. So, please click the red buttons "Apply this script!" and play will ask the user if it is resolved.

Now, you can run the app!

Check out the demo screencast:
https://www.screencast.com/t/7iapOXXZ
