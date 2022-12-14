<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />
<div class="container mt-3">
    <h2 class="m-3 col-12 text-center">Park Visits</h2>
    <img src="../../pub/IMG_1769.jpg" alt="Mountain against background of night scky with stars" style="max-width: 100%;height: auto;" class="col-12 mb-3 border border-white">
<table class="table table-bordered" style="background-color:tan">
    <tr>
        <th>Park</th>
        <th>User</th>
        <th>Description</th>
        <th>Start</th>
        <th>End</th>
        <th>Link</th>
    </tr>
    <c:forEach items="${visits}" var="visits">
        <tr>
            <td>${visits.natpark}</td>
            <td>${visits.user}</td>
            <td>${visits.description}</td>
            <td>${visits.start}</td>
            <td>${visits.end}</td>
            <td><a href="/events?id=${visits.id}">link</a></td>
        </tr>
    </c:forEach>
</table>

<a href="/createVisit" class = "btn btn-primary">New Visit</a>
</div>
<jsp:include page="include/footer.jsp" />