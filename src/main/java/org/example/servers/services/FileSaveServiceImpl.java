package org.example.servers.services;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSaveServiceImpl implements FileSaveService {

    @Override
    public boolean dirExists(String destination) {
        return Files.exists(Path.of(destination));
    }

    @Override
    public boolean isFileUploaded(Part part) {
        long fileSize = part.getSize();
        String fileName = part.getSubmittedFileName();
        return fileName != null && !fileName.isBlank() && fileSize > 0;
    }

    @Override
    public String saveFile(Part part, String destination) {
        String fileName = part.getSubmittedFileName();
        String message = String.format("Файл \"%s\" был успешно загружен в директорию \"%s\".<br/>", fileName, destination);
        try {
            InputStream fileStream = part.getInputStream();
            Files.copy(fileStream, Paths.get(destination + File.separator + fileName));
        } catch (FileAlreadyExistsException e) {
            message = String.format("Файл \"%s\" уже существует в директории \"%s\".<br/>", fileName, destination);
        } catch (IOException e) {
            message = String.format("Возникли проблемы при загрузке файла \"%s\"", fileName);
        }
        return message;
    }
}
