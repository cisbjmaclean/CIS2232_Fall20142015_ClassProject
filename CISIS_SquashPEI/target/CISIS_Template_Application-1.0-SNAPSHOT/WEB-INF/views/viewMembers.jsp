<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:nestedPath path="menu">
    <form action="" method="post">
        <table>
            <tr>
                <td colspan="1"><h2>Active Members</h2></td>
                <td><a href="havetoaddalist">add member</a>
                </td>
            </tr>
            <tr>
                <td>
                    ${message}

                </td>
            </tr>
            <c:forEach var="thisMember" items="${members}"
                       varStatus="loopCounter">
                <tr>
                    <td><c:out value="${thisMember.lastName}" />, <c:out value="${thisMember.firstName}" /></td>
                    <td><a href="hastobespecified">edit</a>&nbsp;<a href="hastobespecified">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</spring:nestedPath>
