

<%@page import="ch.hearc.ig.industrialisation.serie4b.services.AccountServices"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.services.AccountServices"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.business.Account"%>
<!-- made by /-\|\|()|\|`/|\/|()|_|5  |?()><()|?-->

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
               Account acc = new Account(Integer.valueOf(request.getParameter("number")),request.getParameter("label"),Float.valueOf(request.getParameter("balance")) ,Float.valueOf(request.getParameter("rate")) ,Integer.valueOf(request.getParameter("idCustomer")));
              
            if (request.getParameter("action").equals("add")) {
                
                AccountServices.insertAccount(acc);
            } else if (request.getParameter("action").equals("delete")) {
                //System.out.println("suppression");
               
                AccountServices.deleteAccount(acc);
            } else {
//        System.out.println("update");
                 AccountServices.updateAccount(acc);
            }
            
        %>
        <a href="customer.jsp?idCustomer=<%=request.getParameter("idCustomer")%>">Retour à la liste des comptes du client</a>
    </body>
</html>
