# Start Prometheus container

docker run \
    --net host \
    -v ./prometheus.yml:/etc/prometheus/prometheus.yml \
    prom/prometheus