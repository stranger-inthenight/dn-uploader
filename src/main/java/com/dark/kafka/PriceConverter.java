package com.dark.kafka;

import javax.enterprise.context.ApplicationScoped;

import com.dark.model.Item;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

/**
 * Date: 2020-10-11
 */
@ApplicationScoped
public class PriceConverter {

    @Incoming("prices")
    @Outgoing("my-data-stream")
    @Broadcast
    public Item process(Item item) {
        return item;
    }
}
