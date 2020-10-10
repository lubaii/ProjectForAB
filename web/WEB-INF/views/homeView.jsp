<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <script src="/javascript/script.js"></script>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
</head>

<body>

<a href="${pageContext.request.contextPath}/login">
    Регистрация
</a>
&nbsp;
<span style="color:red">[ ${loginedUser.userName} ]</span>

<h3>Скачать файл только с расширением txt</h3>
<br/>
Скачать фотографию: <a href="DownloadServlet?param=jpg">test.jpg</a>
</p>
Скачать файл: <a href="DownloadServlet?param=txt">test.txt</a>

<%--<a href="DownloadServlet?param=value">click</a>--%>

<%--<form name="submitForm" method="POST" action="DownloadServlet">
    <input id="txt" type="checkbox" name="txt" value="txt">test.txt<br>
    <p/>
    <input id="jpg" type="checkbox" name="jpg" value="jpg">test.jpg<br>
    <p><input type="submit" value="Скачать"></p>
</form>--%>


</body>
</html>
