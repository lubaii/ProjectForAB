package download;

import bean.UserAccount;
import units.AppUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

//@WebServlet({"/DownloadServlet","/DownloadServlet2"})
//@WebServlet(name ="/DownloadServlet",urlPatterns = { "*.jpg", "*.txt" })
//@WebServlet(name ="/DownloadServlet",urlPatterns = { "/test", "/test2" })
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    UserAccount loginedUser = null;
    //private final String DOWNLOAD_TXT_="C:\\Users\\User\\Desktop\\test.txt";;
    //  private final String DOWNLOAD_JPG_="C:\\Users\\User\\Desktop\\test2.jpg";

    private final String DOWNLOAD_TXT_ = "C:\\Users\\User\\Progects\\ProjectForAB\\web\\WEB-INF\\files\\test.txt";
    private final String DOWNLOAD_JPG_ = "C:\\Users\\User\\Progects\\ProjectForAB\\web\\WEB-INF\\files\\test2.jpg";

    private String filePath;

    public DownloadServlet() {
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // Получить значение параметра инициализирования (initialization parameter) Servlet.
        // (По конфигурации данный Servlet в web.xml).
        this.filePath = config.getInitParameter("test");
    }

    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginedUser = AppUtils.getLoginedUser(request.getSession());
        String servletPath = request.getServletPath();
        ServletOutputStream out = response.getOutputStream();
        String gettxt = request.getParameter("txt");
        String getjpg = request.getParameter("jpg");

        if (gettxt != null || getjpg != null) {
            if (gettxt == null && getjpg != null) {
                if (servletPath.equals("/DownloadServlet") && loginedUser == null) {
                    response.sendRedirect(request.getContextPath() + "/login");
                    return;
                } else filePath = DOWNLOAD_JPG_;
            }
            else   if (gettxt != null && getjpg == null) {
                if (gettxt.equals("txt")) {
                    filePath = DOWNLOAD_TXT_;
                }else response.sendRedirect(request.getContextPath() + "/login");
            }
            //else  if (servletPath.equals("/DownloadServlet")&&loginedUser==null){
            ;
        } if (gettxt != null && getjpg != null){
            out.write("Выберете файл txt для скачивания".getBytes("UTF-8"));}
        else
            out.write("Выберете файл для скачивания".getBytes("UTF-8"));
        //selvletContext.setAttribute("warning","Выберете значения");


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
