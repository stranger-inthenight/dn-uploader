package com.dark.kafka;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dark.model.Item;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

/**
 * Date: 2020-10-11
 */
@Path("/prices")
public class PriceResource {

    @Inject
    @Channel("my-data-stream")
    Publisher<Item> itemPublisher;
    @Inject
    @Channel("price-create")
    Emitter<Item> priceEmitter;

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType(MediaType.APPLICATION_JSON)
    public Publisher<Item> stream() {
        return itemPublisher;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPrice(Item price) {
        priceEmitter.send(price);
    }
}