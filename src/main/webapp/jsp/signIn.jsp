<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Страница входа</title>
</head>
<body>
<h1>Вход</h1>
<h2>Введите свои данные:</h2>
<form action="signIn" method="post">
    <label for="email">Введите email:</label>
    <input type="email" id="eMail" name="eMail" placeholder="Ваш email"><br/>
    <label for="password">Введите пароль:</label>
    <input type="password" id="password" name="password" placeholder="Ваш пароль"> <br/>
    <input type="submit" value="Войти">
</form>
</body>
</html>
