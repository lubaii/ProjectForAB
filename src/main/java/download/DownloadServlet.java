package download;

import bean.UserAccount;
import units.AppUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    UserAccount loginedUser = null;
    private final String DOWNLOAD_TXT_ = "C:\\Users\\User\\Progects\\ProjectForAB\\web\\WEB-INF\\files\\test.txt";
    private final String DOWNLOAD_JPG_ = "C:\\Users\\User\\Progects\\ProjectForAB\\web\\WEB-INF\\files\\test2.jpg";

    private String filePath;

    public DownloadServlet() {

    }

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginedUser = AppUtils.getLoginedUser(request.getSession());
        String servletPath = request.getServletPath();
        String gettxt = request.getParameter("txt");
        String getjpg = request.getParameter("jpg");

        if (gettxt != null || getjpg != null) {
            if (gettxt == null && getjpg != null) {
                if (servletPath.equals("/DownloadServlet") && loginedUser == null) {
                    response.sendRedirect(request.getContextPath() + "/login");
                    return;
                } else filePath = DOWNLOAD_JPG_;
            } else if (gettxt != null && getjpg == null) {
                if (gettxt.equals("txt")) {
                    filePath = DOWNLOAD_TXT_;
                } else response.sendRedirect(request.getContextPath() + "/login");
            }
        } else {
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.write("<p> Выберете файл для скачивания</p>");
            out.close();
        }



        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
        response.setContentLength((int) downloadFile.length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);

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
