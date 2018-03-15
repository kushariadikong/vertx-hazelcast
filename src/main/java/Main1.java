import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

public class Main1 {
    public static void main(String []args) {
        ClusterManager manager = new HazelcastClusterManager();

        VertxOptions options = new VertxOptions().setClusterManager(manager);

        Vertx.clusteredVertx(options, res -> {
            if (res.succeeded()) {
                Vertx vertx = res.result();
                vertx.deployVerticle(new WebVerticle1());
            }
            else {
                System.out.println("Error starting verticle");
            }
        });
    }
}
