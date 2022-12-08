<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<div class="container">
	<div class="row mt-3 mb-1">
		<h2>Create User</h2>
	</div>
	<c:if test="${bindingResult.hasErrors()}">
        <c:forEach items="${bindingResult.getAllErrors()}" var="error">
            <p class="mb-0" style="color:red">${error.getDefaultMessage()}</p>
        </c:forEach>
    </c:if>
	<form action="/signup/createuser" method="POST">
		<div class="row">
			<div class="mb-3 col-6">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" value="${form.firstname}" name="firstname" class="form-control" id="firstName" aria-describedby="firstNameHelp">
                <div id="fristNameHelp" class="form-text">Please give us your first name</div>
            </div>

            <div class="mb-3 col-6">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" value="${form.lastname}" name="lastname" class="form-control" id="lastName" aria-describedby="lastNameHelp">
                <div id="lastNameHelp" class="form-text">Please give us your last name</div>
            </div>
		</div>
		<div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" value="${form.email}" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">Please enter your email</div>
        </div>
        <div class="mb-3">
            <label for="exampleInputUsername" class="form-label">Username</label>
            <input type="text" value="${form.username}" name="username" class="form-control" id="exampleInputUsername" aria-describedby="usernameHelp">
            <div id="username" class="form-text">Please enter your desired username</div>
        </div>
		<div class="row">
            <div class="mb-3 col-6">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" value="${form.password}" name="password" class="form-control" id="exampleInputPassword1">
            </div>

            <div class="mb-3 col-6">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" value="${form.confirmPassword}" name="confirmPassword" class="form-control" id="confirmPassword">
            </div>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">About You</label>
            <textarea rows="5" cols="50" class="form-control" id="description" name="description"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
	
	</form>
	
</div>


<jsp:include page="include/footer.jsp" />