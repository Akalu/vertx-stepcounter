[![Generic badge](https://img.shields.io/badge/vert.x-4.0.3-purple.svg)[https://vertx.io]

About
======

This is a simple server application which implements a simple CRUD service with Postgres as a backend and reactive API, built on the basis of Vert.x framework

Demonstrates the using of the following technologies:

* Apache Kafka as a source of data to persist

* Exposing public end points to access the data saved in the database

* Test containers for integration tests 

public api:

| Method | Endpoint                   |Secure|      Description                               |
|--------|----------------------------|------|------------------------------------------------|
|GET     |  /deviceId/total           |  No  |    value of counter for specific device        |
|GET     |  /deviceId/year/month      |  No  |    value of counter for specific month         |
|GET     |  /deviceId/year/month/day  |  No  |    value of counter for specific day           |


Building
=========


To launch your tests:

```
mvn clean test
```

To package your application:

```
mvn clean package
```

To run your application:

```
java -cp ./target/vxcore-1.0.0-SNAPSHOT-fat.jar verticle.StepServer 
```

Run all containers, then create a record in <code>step</code> table with device_id=1

Perform the GET request to the following endpoint: 

```
GET http://localhost:3001/1/total

{"count":123}
```


Reference
==========


* (https://vertx.io/docs/)[Vert.x Documentation]
* (https://stackoverflow.com/questions/tagged/vert.x?sort=newest&pageSize=15)[Vert.x Stack Overflow]
* (http://start.vertx.io)[Vert.x Initializr]


