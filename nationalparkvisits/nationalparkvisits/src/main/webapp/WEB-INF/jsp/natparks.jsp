<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />
<sec:authorize access="isAnyAuthority()">
<div class="container mt-3">
    <h2 class="m-3 col-12 text-center">National Parks</h2>
    <img src="../../pub/IMG_1745.jpg" alt="Mountain against background of night scky with stars" style="max-width: 100%;height: auto;" class="col-12 mb-3">
<table class="table table-bordered">
    <tr>
        <th>NAME</th>
        <th>State</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${nationalParks}" var="nationalParks">
        <tr>
            <td><a href="/parkVisits?id=${nationalParks.id}">${nationalParks.name}</a></td>
            <td>${nationalParks.state}</td>
            <td>${nationalParks.description}</td>
        </tr>
    </c:forEach>
</table>
</div>
</sec:authorize>

<jsp:include page="include/footer.jsp" />