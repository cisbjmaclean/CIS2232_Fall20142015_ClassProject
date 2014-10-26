<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:nestedPath path="menu">
    <form action="menu" method="post">
        <body>
            <table>                     
                <tr>
                    <td>        <input type="submit" name="action" value="My Information">
                    </td>
                </tr>
                <tr>
                    <td>        <input type="submit" name="action" value="Make Payment">
                    </td>
                </tr>
                <tr>
                    <td>        <input type="submit" name="action" value="Reports">
                    </td>
                </tr>
                <tr>
                    <td>        <input type="submit" name="action" value="Logout">
                    </td>
                </tr>
                <tr>
                    <td><fmt:message key="label.admin" />
                    </td>
                </tr>
                <tr>
                    <td>        <input type="submit" name="action" value="Members">
                    </td>
                </tr>
                <tr>
                    <td>        <input type="submit" name="action" value="Notifications">
                    </td>
                </tr>
                <tr>
                    <td>        <input type="submit" name="action" value="View Codes">
                    </td>
                </tr>
            </table>
        </body>
    </form>
    </spring:nestedPath>
