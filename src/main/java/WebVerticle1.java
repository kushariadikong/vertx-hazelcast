import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class WebVerticle1 extends AbstractVerticle{
    @Override
    public void start() throws Exception {
        HttpServer http = vertx.createHttpServer();
        Router router = Router.router(vertx);

        router.get("/").handler(request-> {
            request.response().end("Hello from: " + deploymentID());
        });

        http.requestHandler(router::accept);

        http.listen(8080);
    }
}
