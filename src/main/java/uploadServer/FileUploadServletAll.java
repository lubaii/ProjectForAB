package uploadServer;

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

@WebServlet("/uploadServerAll")
@MultipartConfig
public class FileUploadServletAll extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "C:\\Users\\User\\Desktop\\1";


    public FileUploadServletAll() {
        super();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part filePart = request.getPart("file");

        String fileName = filePart.getSubmittedFileName();

            InputStream fileInputStream = filePart.getInputStream();
            File fileToSave = new File(UPLOAD_DIRECTORY + fileName);
            Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);



        getServletContext().getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request,response);
    }

}
