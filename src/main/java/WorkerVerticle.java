/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OPTIMUS
 */
public class WorkerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception{
        vertx.eventBus().consumer(s:"hello").handler(objectMessage -> {
            Pesan pesan = JsonObject.mapFrom(objectMessage.body()).mapTo(Pesan.class);
            objectMessage.reply(JsonObject.mapFrom(new Pesan("Hello " + pesan.getPesan()+ " from " + deploymentID())));
        });
    }
     
}
