
<%@page import="ch.hearc.ig.industrialisation.serie4b.services.CustomerServices"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.business.Address"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.business.Bank"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.business.Customer"%>
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

            Customer cus = new Customer();
            cus.setFirstName(request.getParameter("lastName"));
            cus.setLastName(request.getParameter("firstName"));
            Bank bk = new Bank();
            bk.setId(1);

            if (request.getParameter("action").equals("add")) {
                Address adr = new Address();
                adr.setId(Integer.parseInt(request.getParameter("address")));
                cus.setAddress(adr);
                cus.setBank(bk);
                CustomerServices.insert(cus);
            } else if (request.getParameter("action").equals("delete")) {
                //System.out.println("suppression");
                cus.setNumber(Integer.valueOf(request.getParameter("number")));
                CustomerServices.delete(cus);
            } else {
                Address adr = new Address();
                adr.setId(Integer.valueOf(request.getParameter("address")));
                cus.setAddress(adr);
                cus.setNumero(Integer.valueOf(request.getParameter("number")));
                CustomerServices.update(cus);
            }

        %>
        <a href="bank.jsp">Return to custormer list</a>
    </body>
</html>
