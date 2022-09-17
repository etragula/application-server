package org.example.servers.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servers.services.FileSaveService;

import java.io.IOException;

import static org.example.servers.services.FileSaveService.BACK_TO_FILE_UPLOAD_BUTTON;

@WebServlet(name = "UploadOneFile", urlPatterns = "/oneFileUpload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UploadOneFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/uploadOneFile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        var fileSaveService = new FileSaveService();
        var filePart = req.getPart("file");
        var destination = req.getParameter("destination");
        var writer = resp.getWriter();

        if (fileSaveService.fileIsAbsent(filePart)) {
            writer.println("Файл для загрузки не был выбран.<br/>");
        } else if (fileSaveService.dirNotExists(destination)) {
            writer.println("Не удалось загрузить файл. Указана несуществующая директория.<br/>");
        } else {
            writer.println(fileSaveService.saveFile(filePart, destination));
        }

        writer.println(BACK_TO_FILE_UPLOAD_BUTTON);
        writer.close();
    }
}
