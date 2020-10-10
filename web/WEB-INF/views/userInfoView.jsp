
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Это страница: ${loginedUser.userName}</h3>

 <b>Вы можете скачать файлы с другими расширениями</b>

<br/>
Скачать фотографию: <a href="DownloadServlet?param=jpg">test.jpg</a>
</p>
Скачать файл: <a href="DownloadServlet?param=txt">test.txt</a>

<%--<form name="submitForm" method="POST" action="DownloadServlet">
    <input type="checkbox" name="txt" value="txt">test.txt<br>
    <p/>
    <input type="checkbox" name="jpg" value="jpg">test.jpg<br>
    <p><input type="submit" value="Скачать"></p>
</form>

<script>
    inputs = document.getElementsByTagName("input");
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].type == "checkbox") {
            inputs[i].onchange = function () {
                inputs = document.getElementsByTagName("input");
                for (var i = 0; i < inputs.length; i++) {
                    if (inputs[i].type == "checkbox") {
                        inputs[i].checked = false;
                    }
                    this.checked = true;
                }
            }
        }
    }

</script>--%>

</body>
</html>
