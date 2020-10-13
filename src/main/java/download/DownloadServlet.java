package download;

import bean.UserAccount;
import units.AppUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    UserAccount loginedUser = null;

    public DownloadServlet() {

    }


    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File relationFail = new File(this.getServletContext().getRealPath("/WEB-INF/files/"));
        loginedUser = AppUtils.getLoginedUser(request.getSession());
        String servletPath = request.getServletPath();
        String fileName = request.getParameter("param");
        String filePath = relationFail + File.separator + fileName; //
        if(!fileName.endsWith(".txt")){
            if (servletPath.equals("/download") && loginedUser == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return;
            }
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
