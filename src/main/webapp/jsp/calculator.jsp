<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Some Page</title>
</head>
<body>
<form method="POST" action="calculator">
    <input type="text" name="Number" placeholder="Введите число"> <br/>
    <label style="color:red;font-size: x-small">${error}</label> <br/>
    <input type="submit" value="Отправить">
</form>
</body>
</html>
