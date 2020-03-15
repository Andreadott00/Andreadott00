<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="l"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ page import="info.java.tips.form.AppuntamentoForm"%>
<jsp:useBean id="listaAppuntamento" scope="session"
	class="info.java.tips.form.ListaAppuntamenti" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>
	<b:write name='provaForm' property='username' />
	ecco la tua Agenda :)
	<br>
	<br>
	<form action="/appuntamento">
		<hr>
		<div>
			<h:form action="/crea">
				<h:text property="data" />
				<h:text property="ora" />
				<h:text property="descrizione" />
				<hr />
				<h:errors />
			</h:form>
		</div>
		<hr>
		<table>
			<tr>
				<th>Data</th>
				<th>Ora</th>
				<th>Descrizione</th>
				<%
					for (AppuntamentoForm app : listaAppuntamento.getListaAppuntamento()) {
						out.println("<tr>");
						out.println("<td>" + app.getData() + "</td>");
						out.println("<td>" + app.getOra() + "</td>");
						out.println("<td>" + app.getDescrizione() + "</td>");
						out.println("<td>" + "<h:form action='/modifica'>");
						out.println("<input type='hidden' name='id' value='" + app.getId() + "'>");
						out.println("<input type='submit' value='Modifica')'>");
						out.println("</form>" + "</td>");
						out.println("<td>" + "<h:form action='/cancella'>");
						out.println("<input type='hidden' name='id' value='" + app.getId() + "'>");
						out.println("<input type='submit' value='Elimina')'>");
						out.println("</form>" + "</td>");
						out.println("</tr>");

					}
				%>
			
		</table>
	</form>
</body>
</html>



