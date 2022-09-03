package org.example.servers.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.servers.services.FileSaveService;
import org.example.servers.services.FileSaveServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.servers.enums.HtmlAttributes.BACK_TO_FILE_UPLOAD_BUTTON;

@WebServlet(name = "UploadTwoFiles", urlPatterns = "/twoFilesUpload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 mb
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UploadTwoFilesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/uploadTwoFiles.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        FileSaveService fileSaveService = new FileSaveServiceImpl();
        String destination = req.getParameter("destination");
        PrintWriter writer = resp.getWriter();
        List<Part> parts = req.getParts().stream()
                .filter(fileSaveService::fileIsAbsent)
                .collect(Collectors.toList());

        if (parts.isEmpty()) {
            writer.println("Не были выбраны файлы для загрузки.<br/>");
        } else if (fileSaveService.dirNotExists(destination)) {
            writer.println("Не удалось загрузить файлы. Указана несуществующая директория.<br/>");
        } else {
            parts.forEach(part -> writer.println(fileSaveService.saveFile(part, destination)));
        }

        writer.println(BACK_TO_FILE_UPLOAD_BUTTON.getValue());
        writer.close();
    }
}
