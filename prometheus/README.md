# Inicio de Prometheus

```bash
docker run \
    --net host \
    -v ./prometheus.yml:/etc/prometheus/prometheus.yml \
    prom/prometheus
```