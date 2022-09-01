package org.example.servers.services;

import jakarta.servlet.http.Part;

public interface FileSaveService {

    boolean dirNotExists(String destination);

    boolean isFileUploaded(Part part);

    String saveFile(Part part, String destination);
}
