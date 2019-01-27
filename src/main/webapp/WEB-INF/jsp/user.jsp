<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    <link rel="stylesheet" type="text/css" href="css/user.css"/>
</head>
<body>
<h2>Zostales dodany do bazy jako ......</h2>
<div id="container">
<table>
    <tr>
        <td>Imie</td>
        <td>${registryName}</td>
    </tr>
    <tr>
        <td>Nazwisko</td>
        <td>${registrySurname}</td>
    </tr>
    <tr>
        <td>Haslo</td>
        <td>${registryPassword}</td>
    </tr>
</table>
<form id="forma" action="/login" method="post">
    <input type="submit" value="Powrot do logowania">
</form>
</div>
</body>
</html>