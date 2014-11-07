
<%@page import="ch.hearc.ig.industrialisation.serie4b.services.CustomerServices"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.business.Customer"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.LinkedList"%>

<!-- made by /-\|\|()|\|`/|\/|()|_|5  |?()><()|?-->
<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; chacet=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bank HE-ARC</h1>
        <p>Customers : </p>
        <%
            Set<Customer> customers = new LinkedHashSet<Customer>();
            customers = CustomerServices.findAllCustomer();
            for (Customer c : customers) {
                
                
        %>

        <a href="customer.jsp?idCustomer=<%=c.getNumber()%>"><%=c.getLastName() + " " + c.getFirstName()%></a> - 
        <a href="formCustomer.jsp?action=edit&number=<%=c.getNumber()%>&lastName=<%=c.getFirstName()%>&firstName=<%=c.getLastName()%>&address=<%=c.getAddress().getId()%>">editer</a> - 
        <a href="editCustomer.jsp?action=delete&number=<%=c.getNumber()%>">supprimer</a><br />


        <%}%>
        <a href="formCustomer.jsp?action=add&number=0&lastName=&firstName=&address=0">Ajouter un client</a>
        
    </body>
</html>
