
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
        <h1>Add/edit for a customer</h1>
        <form method="GET" action="editCustomer.jsp">
            <input type="hidden" name="action" value="<%=request.getParameter("action")%>" />
            <input type="hidden" name="number" value="<%=request.getParameter("number")%>" />
            <label for="lastName">Nom</label>
            <input type="text" name="lastName" id="lastName" value="<%=request.getParameter("lastName")%>" /><br />
            <label for="firstName">Prénom</label>
            <input type="text" name="firstName" id="firstName" value="<%=request.getParameter("firstName")%>" /><br />
            <label for="address">Adresse</label>
            <select name="address" id="address">
                <%
                    Set<Address> addresses = AddressServices.getAllAddress();
                    for (Address addr : addresses) {
                %>
                <option value="<%=addr.getId()%>"<% if (Integer.parseInt(request.getParameter("address")) == addr.getId()) {%> selected="true"<%}%>><%=addr.getStreet() + " - " + addr.getZipCode()+ " " + addr.getCity()%></option>
                <%
                    }
                %>
            </select><br />
            <input type="submit" value="Valider" /><br />
            <a href="bank.jsp"><input type="button" value="Annuler" /></a>
        </form>
    </body>
</html>
