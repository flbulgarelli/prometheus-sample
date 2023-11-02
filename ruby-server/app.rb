require 'rack'
require 'prometheus/middleware/collector'
require 'prometheus/middleware/exporter'
require 'prometheus/client'
require 'sinatra'
require 'json'

# ====================
# Métricas automáticas
# ====================

use Rack::Deflater
use Prometheus::Middleware::Collector
use Prometheus::Middleware::Exporter

# =======================
# Métricas personalizadas
# =======================

prometheus = Prometheus::Client.registry

hellos = prometheus.counter(:hellos, docstring: 'A counter of hellos')
byes = prometheus.counter(:byes, docstring: 'A counter of byes')
open_conversations = prometheus.gauge(:convs, docstring: 'A gauge of open conversations')

# ===============
# Aplicación HTTP
# ===============

get '/hello' do
  hellos.increment
  open_conversations.increment

  'hello'
end


get '/bye' do
  byes.increment
  open_conversations.decrement

  'bye'
end
