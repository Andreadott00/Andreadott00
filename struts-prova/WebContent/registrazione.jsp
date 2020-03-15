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
<h:form action="/registrazione">
	Username <h:text property="username">*</h:text> <br>
	Password <h:password property="password">*</h:password> <br>
	Nome <h:text property="nome">*</h:text> <br>
	Cognome <h:text property="cognome">*</h:text> <br>
	Email <h:text property="email">*</h:text> <br>
	Telefono <h:text property="telefono"></h:text> <br>
	<h:submit>Avanti</h:submit>
	<hr />
	<h:errors />
</h:form>
</body>
</html>


