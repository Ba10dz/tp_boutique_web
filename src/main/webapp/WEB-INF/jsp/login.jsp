<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><link rel="stylesheet" href="css/style.css"></head>
<body>
<h1>Connexion</h1>
<p style="color:red">${error}</p>
<form action="login" method="post">
    Login: <input type="text" name="login"> (alice/admin)<br>
    Pass: <input type="password" name="password"> (alice123/admin)<br>
    <button type="submit">Se connecter</button>
</form>
</body>
</html>