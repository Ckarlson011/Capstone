<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<table class="table table-bordered">
    <tr>
        <th>Park</th>
        <th>User</th>
        <th>Name</th>
        <th>Description</th>
        <th>Start</th>
        <th>End</th>
    </tr>
    <c:forEach items="${events}" var="events">
        <tr>
            <td>${events.natpark}</td>
            <td>${events.user}</td>
            <td>${events.name}</td>
            <td>${events.description}</td>
            <td>${events.start}</td>
            <td>${events.end}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="include/footer.jsp" />