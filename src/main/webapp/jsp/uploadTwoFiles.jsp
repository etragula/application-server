<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Загрузка файлов</title>
</head>
<body>
<h2>Загрузка файлов</h2>
<form action="twoFilesUpload" method="post" enctype="multipart/form-data">
    Выберете файл:
    <input type="file" name="file1"> <br/>
    Выберете файл:
    <input type="file" name="file2"> <br/>
    Укажите папку для сохранения файлов:
    <input type="text" value="<%=System.getProperty("user.home") + File.separator%>tmp" name="destination"/> <br/>
    <input type="submit" value="Загрузить файлы">
</form>
<form action="<c:url value="/"/>" method="get">
    <input type="submit" value="На главную">
</form>
</body>
</html>