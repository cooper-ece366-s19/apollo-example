package edu.cooper.apolloexample;

import com.spotify.apollo.Environment;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;
import com.spotify.apollo.route.SyncHandler;

public final class App {

  public static void main(String... args) throws LoadingException {
    HttpService.boot(App::init, "calculator-service", args);
  }

  private static void init(final Environment environment) {
    SyncHandler<String> pingHandler = requestContext -> "pong";
    environment
        .routingEngine()
        .registerAutoRoute(Route.sync("GET", "/ping", pingHandler));
  }
}
