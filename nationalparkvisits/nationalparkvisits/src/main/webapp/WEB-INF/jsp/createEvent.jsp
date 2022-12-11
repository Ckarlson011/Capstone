<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<!--TODO add in form to create event-->
<div class="container">
	<div class="row mt-3 mb-1">
		<h2>Create Event</h2>
	</div>
    <c:if test="${bindingResult.hasErrors()}">
        <c:forEach items="${bindingResult.getAllErrors()}" var="error">
            <p class="mb-0" style="color:red">${error.getDefaultMessage()}</p>
        </c:forEach>
    </c:if>
    <form action="/createEvent" method="POST">
        <input type="hidden" name="visitId" value=""><!--TODO-->
		<div class="mb-3">
            <label for="name" class="form-label">Name of the event</label>
            <input type="text" value="${form.name}" name="name" class="form-control" id="name">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">About You</label>
            <textarea rows="5" cols="50" class="form-control" id="description" name="description"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<jsp:include page="include/footer.jsp" />