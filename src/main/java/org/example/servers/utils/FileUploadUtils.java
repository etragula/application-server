package org.example.servers.utils;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadUtils {

    private FileUploadUtils() {
    }

    public static final String BACK_TO_UPLOAD_BUTTON = "<form>\n" +
            "<input type=\"button\" value=\"Вернуться к загрузке\" onclick=\"history.back()\">\n" +
            "</form><br/>";


    public static boolean dirExists(String destination) {
        return Files.exists(Path.of(destination));
    }

    public static boolean isFileUploaded(Part filePart) {
        return filePart.getSubmittedFileName() != null &&
                !filePart.getSubmittedFileName().isBlank() &&
                filePart.getSize() > 0;
    }

    public static void uploadFile(Part filePart, String destination, PrintWriter writer) {
        String fileName = filePart.getSubmittedFileName();
        try {
            Files.copy(filePart.getInputStream(), Paths.get(destination + File.separator + fileName));
            writer.printf("Файл \"%s\" был успешно загружен в директорию \"%s\".<br/>", fileName, destination);
        } catch (FileAlreadyExistsException e) {
            writer.printf("Файл \"%s\" уже существует в директории \"%s\".<br/>", fileName, destination);
        } catch (IOException e) {
            writer.printf("Возникли проблемы при загрузке файла \"%s\"", fileName);
        }
    }
}
