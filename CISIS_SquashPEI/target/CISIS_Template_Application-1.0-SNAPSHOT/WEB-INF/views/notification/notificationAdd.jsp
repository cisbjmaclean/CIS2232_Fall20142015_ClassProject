<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="welcome.title"/></title>
        <html:base/>
    </head>

    <body>
        <h2><fmt:message key="label.notification"/></h2>
        <div>
            <html:form action="notificationAdd">
                <table>                
                    <tr>
                        <td>
                            <label class="alignCenter"  for="notificationType">
                                <strong><fmt:message key="label.notification.type" />:&nbsp;&nbsp;</strong></label>
                                <c:forEach var="thisNotification" items="${sessionScope.notification_types}" varStatus="loopCounter">

                                    <form:radiobutton path="notificationType" value="${thisNotification.codeValueSequence}" />
                                        ${thisNotification.description}
                                    </c:forEach>
                        </td>
                    </tr>

                     <tr>
                    <td><label class="alignCenter"  for="notificationDetail">
                            <strong><fmt:message key="label.notification.detail" /></strong></label><br />
                            <form:textarea  style="max-height:300px; max-width:500px; width: 300px; height: 150px;" path="notificationDetail"/>
                        </td>
                    </tr>
                    
                    <tr/>
                    <tr align="center">
                        <td colspan="2">
                            <input type="submit" value=<fmt:message key="label.submit"/>
                        </td>
                    </tr>
                </table>
            </html:form>
        </div>


    </body>

</html:html>
