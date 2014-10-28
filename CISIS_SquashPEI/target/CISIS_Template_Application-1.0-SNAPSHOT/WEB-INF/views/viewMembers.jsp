<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<spring:nestedPath path="menu">
    <form action="" method="post">
            <table>
                <tr>
                    <td>Active Members
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
                    <td><c:out value="${loopCounter.count}" /></td>
                    <td><c:out value="${thisMember.lastName}" />, <c:out value="${thisMember.firstName}" /></td>
		</tr>
		</c:forEach>
            </table>
    </form>
    </spring:nestedPath>
