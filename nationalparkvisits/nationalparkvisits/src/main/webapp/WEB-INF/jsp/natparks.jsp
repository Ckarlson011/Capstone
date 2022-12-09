<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<table class="table table-bordered">
    <tr>
        <th>NAME</th>
        <th>State</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${nationalParks}" var="nationalParks">
        <tr>
            <td>${nationalParks.name}</td>
            <td>${nationalParks.state}</td>
            <td>${nationalParks.description}</td>
        </tr>
      </c:forEach>
</table>

<jsp:include page="include/footer.jsp" />