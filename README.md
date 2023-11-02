
## Inicio de los servidores

Dirigite a cada uno de los directorios `ruby-server` y `java-server`; en cada uno encontrarás un servidor muy simple (que escucha en los puertos `8000` y `8001`, respectivamente) soporta las rutas `/hello` y `/bye`.

Iniciá cada uno de los servidores siguiendo las instrucciones en sus respectivos `README`

## Inicio de Prometheus

Dirigite al directorio `prometheus`. Allí encontrarás la configuración de un servidor prometheus capaz de procesar: 

* sus propias métricas
* las métricas del servidor java
* las métricas del servidor ruby

Seguí las instrucciones e iniciá el servidor. Luego ingresá a http://localhost:9000 y creá visualizaciones para:

* `hellos`, `byes`, `convs` (métricas de ambos servidores)
* `jvm_memory_used_bytes` (métrica sólo del servidor java)
* `http_server_requests_total` (métrica sólo del servidor ruby)

Observá como cambian estas gráficas a medida que se realizan pedidos HTTP a cada uno de los servidores. Compará los resultados con las rutas `/metrics` de cada uno de los servidores y como los mismos pueden ser filtrados utilizando el operador `{}`. Ejemplos: 

![image](https://github.com/flbulgarelli/prometheus-sample/assets/677436/bee70cd2-e393-4b84-af11-ce6f8d781e38)

![Screenshot 2023-11-02 at 01-52-24 Prometheus Time Series Collection and Processing Server](https://github.com/flbulgarelli/prometheus-sample/assets/677436/e432567f-6bde-4d92-8cf6-564bbf44dcbc)

![Screenshot 2023-11-02 at 01-53-57 Prometheus Time Series Collection and Processing Server](https://github.com/flbulgarelli/prometheus-sample/assets/677436/e770886f-23f1-4cf5-ada8-eb2b5173ae0e)

¿Qué otros tipos de métricas se pueden encontrar?




