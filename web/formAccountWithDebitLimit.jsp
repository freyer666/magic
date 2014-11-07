<!-- made by /-\|\|()|\|`/|\/|()|_|5  |?()><()|?-->
<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add/edit for a debit limit account</h1>
        <form method="get" action="editAccountWithDebitLimit.jsp">
            <input type="hidden" name="action" value="<%=request.getParameter("action")%>" />
            <input type="hidden" name="number" value="<%=request.getParameter("number")%>" />
            <input type="hidden" name="idCustomer" value="<%=request.getParameter("idCustomer")%>" />
            <label for="label">Libelle</label>
            <input type="text" name="label" id="label" value="<%=request.getParameter("label")%>" /><br />
            <label for="balance">Solde</label>
            <input type="text" name="balance" id="balance" value="<%=request.getParameter("balance")%>" /><br />
            <label for="rate">Taux</label>
            <input type="text" name="rate" id="rate" value="<%=request.getParameter("rate")%>" /><br />
            <label for="limit">Plafond de débit</label>
            <input type="text" name="limit" id="limit" value="<%=request.getParameter("limit")%>" /><br />
            <input type="submit" value="Valider" />
            <a href="customer.jsp?idCustomer=<%=request.getParameter("idCustomer")%>"><input type="button" value="Annuler" /></a>
        </form>
    </body>
</html>
