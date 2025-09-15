package com.resumeanalyzer.util;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class FileParser {

    private static final Tika tika = new Tika();

    /**
     * Extracts text content from uploaded resume file
     * @param file MultipartFile uploaded
     * @return extracted text as String
     * @throws IOException if reading fails
     */
    public static String parseFile(MultipartFile file) throws IOException, TikaException {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty or null");
        }
        return tika.parseToString(file.getInputStream());
    }
}
