<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />
<div class="container mt-3">
<table class="table table-bordered">
    <tr>
        <th>Park</th>
        <th>User</th>
        <th>Name</th>
        <th>Description</th>
        <th>Start</th>
        <th>End</th>
        <th>Edit Event</th>
    </tr>
    <c:forEach items="${events}" var="events">
        <tr>
            <td>${events.natpark}</td>
            <td>${events.user}</td>
            <td>${events.name}</td>
            <td>${events.description}</td>
            <td>${events.start}</td>
            <td>${events.end}</td>
            <td><a href="/editEvent/?id=${events.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>

<a href="/createEvent?visit_id=${param.id}" class="btn btn-primary">New Event</a>
</div>
<jsp:include page="include/footer.jsp" />