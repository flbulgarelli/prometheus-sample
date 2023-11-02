## Instalación

```bash
bundle install
```

## Inicio del servidor


```bash
bundle exec ruby app.rb -p 8000
```

## Prueba del servidor

```bash
curl http://localhost:8000/hello -i
curl http://localhost:8000/bye -i
curl http://localhost:8000/metrics -i
```
