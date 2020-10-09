<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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

<form name="submitForm" method="POST" action="DownloadServlet">
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

</script>
</body>
</html>

