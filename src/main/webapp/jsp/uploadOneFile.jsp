<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Загрузка файла</title>
</head>
<body>
<h2>Загрузка файла</h2>
<form action="oneFileUpload" method="post" enctype="multipart/form-data">
    Выберете файл:
    <input type="file" name="file"> <br/>
    Укажите папку для сохранения:
    <input type="text" value="<%=System.getProperty("user.home") + File.separator%>tmp" name="destination"/> <br/>
    <input type="submit" value="Загрузить файл">
</form>
<form action="main" method="get">
    <input type="submit" value="На главную">
</form>
</body>
</html>