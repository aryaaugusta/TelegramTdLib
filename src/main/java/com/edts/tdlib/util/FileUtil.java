package com.edts.tdlib.util;

import com.edts.tdlib.constant.DocumentTypeConstant;
import com.edts.tdlib.constant.ImageTypeConstant;

import java.util.Optional;
import java.util.UUID;

public final class FileUtil {

    public FileUtil() {
    }

    public static String generateImageFileName(String imageType) {
        String name = UUID.randomUUID().toString();

        switch (imageType) {
            case ImageTypeConstant.JPEG:
                return name + ".jpg";
            case ImageTypeConstant.PNG:
                return name + ".png";
            case ImageTypeConstant.GIF:
                return name + ".gif";
        }

        throw new IllegalArgumentException("Invalid imageType");
    }

    public static String generateDocumentFileName(String fileType) {
        return UUID.randomUUID().toString() + "." + fileType;
    }


    public static Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

}
