import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class WebVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        HttpServer http = vertx.createHttpServer();
        Router router = Router.router(vertx);

        router.get("/:name").handler(request-> {
            String name = request.pathParam(s: "name");
            vertx.eventBus().send(s: "hello", JsonObject.mapFrom(new Pesan(name)), reply -> {
                if (reply.succeeded()){
                    Pesan pesan = JsonObject.mapFrom(reply.result().body().mapTo(Pesan.class);
                    request.response().end(pesan.getPesan());
                    
                }else {
                    request.response().end(s: "Error Getting Result");
                }
            });
        });
        http.requestHandler(router::accept);

        http.listen(8080);
    }
}
