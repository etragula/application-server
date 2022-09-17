package org.example.servers.services;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSaveService {

    public static final String BACK_TO_FILE_UPLOAD_BUTTON =
            "<form>\n" +
                    "<input type=\"button\" value=\"Вернуться к загрузке\" onclick=\"history.back()\">\n" +
                    "</form> <br/>";

    public boolean dirNotExists(String destination) {
        return Files.notExists(Path.of(destination));
    }

    public boolean fileIsAbsent(Part part) {
        var fileSize = part.getSize();
        var fileName = part.getSubmittedFileName();
        return fileName == null || fileName.isBlank() || fileSize < 0;
    }

    public String saveFile(Part part, String destination) {
        var fileName = part.getSubmittedFileName();
        var resultMessage = String.format("Файл \"%s\" был успешно загружен в директорию \"%s\".<br/>", fileName, destination);
        try {
            var fileStream = part.getInputStream();
            Files.copy(fileStream, Paths.get(destination + File.separator + fileName));
        } catch (FileAlreadyExistsException e) {
            resultMessage = String.format("Файл \"%s\" уже существует в директории \"%s\".<br/>", fileName, destination);
        } catch (IOException e) {
            resultMessage = String.format("Возникли проблемы при загрузке файла \"%s\"", fileName);
        }
        return resultMessage;
    }
}
