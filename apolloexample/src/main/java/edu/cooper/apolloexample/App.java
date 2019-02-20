package edu.cooper.apolloexample;

import com.spotify.apollo.Environment;
import com.spotify.apollo.RequestContext;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;
import com.spotify.apollo.route.SyncHandler;

public final class App {

  public static void main(String... args) throws LoadingException {
    HttpService.boot(App::init, "calculator-service", args);
  }

  private static void init(final Environment environment) {
    SyncHandler<String> pingHandler = requestContext -> {
      int x = 5;
      Integer a = null;
      System.out.println(x);
      Integer y = 5;
      Integer z;
      return "pong";
    };
    final SyncHandler<String> handler = (RequestContext requestContext) ->
        requestContext.pathArgs().get("name");
    environment
        .routingEngine()
        .registerAutoRoute(Route.sync("GET", "/ping", pingHandler))
        .registerAutoRoute(Route.sync("GET", "/name/<name>", handler));
  }
}
