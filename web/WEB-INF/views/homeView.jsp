<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
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

<%--Скачать файл: <a href="DownloadServlet?param=value">test.txt</a>--%>
<%--Скачать файл: <a href="DownloadServlet">test.txt</a>
Скачать фотографию: <a href="DownloadServlet">test2.jpg</a>--%>
<%--<form action="DownloadServle" method="get" enctype="multipart/form-data">
    <p>
        <input type="file" name="test.txt">
        <input type="file" name="test2.jpg">
        <input type="submit" value="Скачать"></p>
</form>--%>
<%--<form action="DownloadServlet" method="post">
    <button type="submit" name="your_name" value="your_value" class="btn-link">Go</button>
</form>--%>

<%--<form name="submitForm" method="POST" action="DownloadServlet">
    <input type="hidden" name="txt" value="txt">
    <A HREF="javascript:document.submitForm.submit()">test.txt</A>
</form>--%>

<%--<form name="submitForm" method="POST" action="DownloadServlet">
    <input type="hidden" name="txt" value="txt">
    <A HREF="javascript:document.submitForm.submit()">test.txt</A>
    <p/>
    <input type="hidden" name="jpg" value="jpg">
    <A HREF="javascript:document.submitForm.submit()">test2.jpg</A>
</form>--%>
<form name="submitForm" method="POST" action="DownloadServlet">
    <input type="checkbox" name="txt" value="txt">test.txt<br>
    <p/>
    <input type="checkbox" name="jpg" value="jpg">test.jpg<br>
    <p><input type="submit" value="Скачать"></p>
</form>

<script>
    $('#group input:checkbox').click(function(){
        if ($(this).is(':checked')) {
            $('#group input:checkbox').not(this).prop('checked', false);
        }
    });
</script>

</body>
</html>