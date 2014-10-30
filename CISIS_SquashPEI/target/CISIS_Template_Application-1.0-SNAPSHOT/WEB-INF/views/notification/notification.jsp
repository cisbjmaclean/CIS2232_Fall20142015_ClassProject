<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html:html lang="true">
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="welcome.title"/></title>
    <html:base/>

    <script type="text/javascript">
        function deleteNotification(test, description) {
            var r = confirm("<fmt:message key="label.confirm.delete.notification"/>" + description + "?");
            if (r == true) {
                var s = document.getElementById('action_id');
                s.value = test;

                document.forms[1].action = "/notification?delete=" + test;
                document.forms[1].submit();
            }

        }
    </script> 

</head>

<body>
    <h2><fmt:message key="label.notification"/></h2>
    <div>
        <spring:nestedPath path="menu">

        <html:form  action="menu">
            <form:hidden path="action"/>
            <table>                

                <c:forEach var="thisNotification" items="${notifications}"
                           varStatus="loopCounter">

                    <tr>
                        <td>
                            <c:if test="${thisNotifiation.notificationType == '2'}"><strong></c:if>
                                    ${thisNotification.notificationDetail}
                                <c:if test="${thisNotifiation.notificationType == '2'}"></strong></c:if>
                            </td>
                        </tr>

                        <tr align="center">
                            <td>
                                <input type="button" 
                                       onclick="deleteNotification(${thisNotification.notificationId}, '${thisNotification.notificationId}')" value='<fmt:message key="label.delete"/>'>
                        </td>
                    </tr>

                </c:forEach>
                <tr>
                    <td>
                        <hr/>
                    </td>
                </tr>

                <tr/>
                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value=<fmt:message key="label.add.notification"/>/>
                    </td>
                </tr>
            </table>
        </html:form>
        </spring:nestedPath>
    </div>
</body>

</html:html>
