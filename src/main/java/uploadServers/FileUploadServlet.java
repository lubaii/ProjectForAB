package uploadServers;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@WebServlet("/uploadServer")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "C:\\Users\\User\\Desktop\\1";


    public FileUploadServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");

        String fileName = filePart.getSubmittedFileName();

        if(fileName.endsWith(".txt")) {
            InputStream fileInputStream = filePart.getInputStream();
            File fileToSave = new File(UPLOAD_DIRECTORY + fileName);
            Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        else {

            getServletContext().getRequestDispatcher("/WEB-INF/views/warning.jsp").forward(request,response);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request,response);
    }
}
