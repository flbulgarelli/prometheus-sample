package io.github.flbulgarelli;

import io.javalin.Javalin;
import io.prometheus.metrics.core.metrics.Counter;
import io.prometheus.metrics.core.metrics.Gauge;
import io.prometheus.metrics.exporter.servlet.jakarta.PrometheusMetricsServlet;
import io.prometheus.metrics.instrumentation.jvm.JvmMetrics;

public class Server {
  public static void main(String[] args) {
    // ================
    // Standard Metrics
    // ================

    JvmMetrics.builder().register();

    // ==============
    // Custom Metrics
    // ==============

    var hellos = Counter.builder()
        .name("hellos")
        .help("A counter of hellos")
        .register();

    var byes = Counter.builder()
        .name("byes")
        .help("A counter of byes")
        .register();

    var openConversations = Gauge.builder()
        .name("convs")
        .help("A gauge of open conversations")
        .register();

    // ================
    // HTTP Application
    // ================

    var app = Javalin.create(config -> {
      config.jetty.contextHandlerConfig(handler -> {
        handler.addServlet(PrometheusMetricsServlet.class, "/metrics");
      });
    });

    app.get("/hello", ctx -> {
      hellos.inc();
      openConversations.inc();
      ctx.result("hello");
    });

    app.get("/bye", ctx -> {
      byes.inc();
      openConversations.dec();
      ctx.result("bye");
    });

    app.start(8001);
  }
}
