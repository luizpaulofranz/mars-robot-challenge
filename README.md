# Mars Robot
[![Maintainability](https://api.codeclimate.com/v1/badges/189e4ccd4551f3a94cde/maintainability)](https://codeclimate.com/github/luizpaulofranz/mars-robot-challenge/maintainability)

Mars Robot Code Challenge. In this challange, we have an Rest API, developed with **Java 8 + Spring**, in which we have only one endpoint at all:
```
POST to http://localhost:8080/rest/mars/${MYPARAM}
```
Where `${MYPARAM}` is a string containing the ***movements commands*** to our robot. Are valid commands:

| Command | Action |
| ------- | ------ |
| M | Moves robot foward |
| R | Turns robot right |
| L | Turns robot left |


**Any othe charactere is not recognized by our robot, and will results in error!**
## Mars Terrain
The mars terrain is a world composed by squares, is a **5x5 matrix**. And **our robot starts always in position x=0, y=0 and with the North direction**, so the start position is: (0,0,N).
We use R to turn Right, L to turn Left, and M to Move to the current direction, which could be **N**orth, **S**outh, **E**ast and **W**est.
So a POST request as:
```
http://localhost:8080/rest/mars/MMRMM
```
Will force our robot to move two steps North, turn right and move two steps East.
# Compile and Build
```
mvn clean package
```
This will create a `jar` file inside target folde, and it can be executed with:
```
java -jar evoluum-0.0.1-SNAPSHOT.jar
```
