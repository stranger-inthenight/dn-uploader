package com.dark.kafka;

import com.dark.model.Item;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

/**
 * Date: 2020-10-11
 */
public class ItemDeserializer extends ObjectMapperDeserializer<Item> {

    public ItemDeserializer() {
        super(Item.class);
    }
}
