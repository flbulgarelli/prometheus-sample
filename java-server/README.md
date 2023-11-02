## Instalación

```bash
mvn install
mvn package
```

## Inicio del servidor


```bash
java -jar target/server-jar-with-dependencies.jar
```


## Prueba del servidor

```bash
curl http://localhost:8001/hello -i
curl http://localhost:8001/bye -i
curl http://localhost:8001/metrics -i
```
