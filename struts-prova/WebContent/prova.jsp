<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>
<h:form action="/prova">
	Username <h:text property="username"></h:text>
	Password <h:password property="password"></h:password>
	<h:submit>Avanti</h:submit><br>
	Non sei registrato?<br>
	<a href="/struts-prova/registrazione.jsp">Registrati</a>
	<hr />
	<h:errors />
</h:form>
</body>
</html>