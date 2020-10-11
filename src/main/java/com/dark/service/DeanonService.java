package com.dark.service;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Date: 2020-10-06
 */
@Component
public class DeanonService {

    @Inject
    @Channel("dn-photo")
    Emitter<byte[]> priceEmitter;

    public void uploadPhoto(byte[] bytes) {
        priceEmitter.send(bytes);
    }
}
