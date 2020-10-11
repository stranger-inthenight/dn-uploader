package com.dark.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.dark.exception.DeanonException;
import com.dark.service.DeanonService;
import org.apache.commons.io.IOUtils;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/upload")
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    private static final Tika TIKA = new Tika();
    private static final String SLASH = "/";

    @Inject
    private DeanonService deanonService;

    @POST
    @Path("/photos")
    public Response uploadPhoto(File photo) throws DeanonException {
        byte[] photoBytes = extractPhotoData(photo);
        LOGGER.info("File length: [{}]", photoBytes.length);
        deanonService.uploadPhoto(photoBytes);
        return Response.ok().build();
    }

    private byte[] extractPhotoData(File src) {
        try (InputStream fis = new BufferedInputStream(new FileInputStream(src))) {
            String mime = TIKA.detect(fis, src.getName());
            if (isImage(mime)) {
                return IOUtils.toByteArray(fis);
            }
            LOGGER.warn("The uploaded file mime is [{}]", mime);
            throw new DeanonException("The uploaded file is not image");
        } catch (IOException e) {
            throw new DeanonException(e);
        }
    }

    private boolean isImage(String mime) {
        return mime.contains(SLASH) && mime.split(SLASH)[0].equalsIgnoreCase("image");
    }
}