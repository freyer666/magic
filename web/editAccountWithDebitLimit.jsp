
<%@page import="ch.hearc.ig.industrialisation.serie4b.services.AccountServices"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.business.AccountWithDebitLimit"%>
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
        <h1>Save changes</h1>
        <%
             Integer idAccount = null;
            idAccount = Integer.valueOf(request.getParameter("number"));
           
             AccountWithDebitLimit acc = new AccountWithDebitLimit(Float.valueOf(request.getParameter("limit")),idAccount,request.getParameter("label"),Float.valueOf(request.getParameter("balance")) ,Float.valueOf(request.getParameter("rate")) ,Integer.valueOf(request.getParameter("idCustomer")));
            
            if (request.getParameter("action").equals("add")) {
                AccountServices.insertDLAccount(acc);
            } else if (request.getParameter("action").equals("delete")) {
                //System.out.println("suppression");
                AccountServices.deleteCLAccount(acc);
            } else {
//        System.out.println("update");
                AccountServices.updateCLAccount(acc);
            }
            
        %>
        <a href="customer.jsp?idCustomer=<%=request.getParameter("idCustomer")%>">Retour à la liste des comptes du client</a>
    </body>
</html>
