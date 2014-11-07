
<%@page import="ch.hearc.ig.industrialisation.serie4b.services.AccountDLServices"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.services.AccountCLServices"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.services.AccountServices"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.services.CustomerServices"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.business.AccountWithDebitLimit"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.business.Account"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.business.AccountWithCreditLimit"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.Set"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.datamapper.CustomerMapper"%>
<%@page import="ch.hearc.ig.industrialisation.serie4b.business.Customer"%>
<!-- made by /-\|\|()|\|`/|\/|()|_|5  |?()><()|?-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            Customer c = new Customer();

            c = CustomerServices.getCustomersByNumber(Integer.valueOf(request.getParameter("idCustomer")));
            

        %>
        <h1><%=c.getLastName() + " " + c.getFirstName()%></h1> 
        <%
            Set<Account> ac = new LinkedHashSet<Account>();
            ac = AccountServices.getAllAccountsByCustomer(c.getNumber());
        %>
        <h2>Account</h2>

        <%for (Account a : ac) {%>
        <span><%=a.getLabel() + " - " + a.getBalance() + ".- - " + a.getRate()%>
        </span> 
        <a href="formAccount.jsp?action=edit&number=<%=a.getNumber()%>&label=<%=a.getLabel()%>&balance=<%=a.getBalance()%>&rate=<%=a.getRate()%>&idCustomer=<%=c.getNumber()%>">modifier</a> 
        <a href="formAccount.jsp?action=delete&number=<%=a.getNumber()%>&label=<%=a.getLabel()%>&balance=<%=a.getBalance()%>&rate=<%=a.getRate()%>&idCustomer=<%=c.getNumber()%>">>supprimer</a><br />
        <%}%>
        <a href="formAccount.jsp?action=add&number=0&label=&balance=&rate=&idCustomer=<%=c.getNumber()%>">ajouter</a><br />
        <h2>Account with credit limit</h2>

        <%
            Set<AccountWithCreditLimit> acCreditLimit = new LinkedHashSet<AccountWithCreditLimit>();
            acCreditLimit = AccountCLServices.getAllAccountsCLByCustomer(c.getNumber());

            for (AccountWithCreditLimit a3 : acCreditLimit) { %>
        <span><%=a3.getLabel() + " - " + a3.getBalance() + ".- - " + a3.getRate() + " - LIMITE : " + a3.getLimiteCredit() + ".- - CUMUL : " + a3.getCreditCumul() + ".-"%>
        </span> <a href="formAccountWithCreditLimit.jsp?action=edit&number=<%=a3.getNumber()%>&label=<%=a3.getLabel()%>&balance=<%=a3.getBalance()%>&rate=<%=a3.getRate()%>&limit=<%=a3.getLimiteCredit()%>&idCustomer=<%=c.getNumber()%>">modifier</a>>
        <a href="formAccountWithCreditLimit.jsp?action=delete&number=<%=a3.getNumber()%>&label=<%=a3.getLabel()%>&balance=<%=a3.getBalance()%>&rate=<%=a3.getRate()%>&limit=<%=a3.getLimiteCredit()%>&idCustomer=<%=c.getNumber()%>">supprimer</a> <br />
        
        <%}%>
        <a href="formAccountWithCreditLimit.jsp?action=add&number=0&label=&balance=&rate=&idCustomer=<%=c.getNumber()%>">ajouter</a><br />
        <h2>Account with debit limit</h2>
        <%
            Set<AccountWithDebitLimit> acDebitLimit = new LinkedHashSet<AccountWithDebitLimit>();
            acDebitLimit = AccountDLServices.getAllAccountsDLByCustomer(c.getNumber());

            for (AccountWithDebitLimit a4 : acDebitLimit) {

               
        %>
        <span><%=a4.getLabel() + " - " + a4.getBalance() + ".- - " + a4.getRate() + " - LIMITE : " + a4.getDebitLimit() + ".- - CUMUL : " + a4.getDebitAccumulation() + ".-"%>
        </span> <a href="formAccountWithDebitLimit.jsp?action=edit&number=<%=a4.getNumber()%>&label=<%=a4.getLabel()%>&balance=<%=a4.getBalance()%>&rate=<%=a4.getRate()%>&limit=<%=a4.getDebitLimit()%>&idCustomer=<%=c.getNumber()%>">modifier</a>>
        <a href="formAccountWithDebitLimit.jsp?action=delete&number=<%=a4.getNumber()%>&label=<%=a4.getLabel()%>&balance=<%=a4.getBalance()%>&rate=<%=a4.getRate()%>&limit=<%=a4.getDebitLimit()%>&idCustomer=<%=c.getNumber()%>">supprimer</a> <br />
         <%}%>
        <a href="formAccountWithDebitLimit.jsp?action=add&number=0&label=&balance=&rate=&limit=&idCustomer=<%=c.getNumber()%>">ajouter</a><br />

        <span><a href="bank.jsp">Retour à la banque</a></span>
    </body>
</html>
