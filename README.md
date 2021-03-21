# Bowling Game Command Line Implementation
A bowling game developed using MAVEN and OOP.

## Built With
* [Java 8 :coffee:](https://docs.oracle.com/javase/8/docs/api/)
* [Maven 3 :fallen_leaf:](https://maven.apache.org/)

## Getting Started

### Usage
The program is configured to read a input file with one bowling game of 10 rounds, print the results in the terminal and generate a output file with the same response to further avaliation.

The input and output file can be changed through arguments.

- By default the application will read a file name "input.txt" in the root folder.

### With Maven

* In the root folder run:
```
mvn test clean compile exec:java
```

* To change the input file path:
```
mvn test clean compile exec:java -Dexec.args="your-input-file-path-here.txt"
```

## Bonus Tasks

A simple lambda expression was used in the integration test to navigate through a ArrayList.
