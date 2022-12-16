<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />
<div class="container mt-3">
    <h2 class="m-3 col-12 text-center">Events</h2>
    <img src="../../pub/IMG_1674.jpg" alt="Mountain against background of night scky with stars" style="max-width: 100%;height: auto;" class="col-12 mb-3">
<table class="table table-bordered" style="background-color:antiquewhite">
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