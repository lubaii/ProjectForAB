package download;

import filter.SecurityFilter;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet({"/DownloadServlet","/DownloadServlet2"})
public class DownloadServlet extends HttpServlet {
    private final String DOWNLOAD_TXT_="C:\\Users\\User\\Desktop\\test.txt";;
    private final String DOWNLOAD_JPG_="C:\\Users\\User\\Desktop\\test2.jpg";

    private String filePath;
    public DownloadServlet(String filePath) {

        this.filePath = filePath;
    }

    public DownloadServlet() {
    }

    private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String servletPath = request.getServletPath();
        if (servletPath.equals("/DownloadServlet")){
            filePath = DOWNLOAD_TXT_;
           }
             else filePath = DOWNLOAD_JPG_;


        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
        response.setContentLength((int) downloadFile.length());

        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
	}



}
