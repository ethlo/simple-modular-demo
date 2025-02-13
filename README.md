## module-sample-project

A super-simple demo repository to experiment with Java module descriptors.

Build the project (uses Maven 3.x)
```commandline
mvn clean package
```

Run the example with
```commandline
java --module-path target/classes:target/lib --module com.example.modularproject/com.example.modularproject.Main
```
