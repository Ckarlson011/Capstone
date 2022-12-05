<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<div class="container">
	<div class="row mt-3 mb-1">
		<h2>Create User</h2>
	</div>
	
	<form action="/user/createuser">
		<div class="row">
			<div class="mb-3 col-6">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" name="firstName" class="form-control" id="firstName" aria-describedby="firstNameHelp">
                <div id="fristNameHelp" class="form-text">Please give us your first name</div>
            </div>

            <div class="mb-3 col-6">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" name="lastName" class="form-control" id="lastName" aria-describedby="lastNameHelp">
                <div id="lastNameHelp" class="form-text">Please give us your last name</div>
            </div>
		</div>
		<div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">Please enter your email</div>
        </div>
        <div class="mb-3">
            <label for="exampleInputUsername" class="form-label">Username</label>
            <input type="text" name="username" class="form-control" id="exampleInputUsername" aria-describedby="usernameHelp">
            <div id="username" class="form-text">Please enter your desired username</div>
        </div>
		<div class="row">
            <div class="mb-3 col-6">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="exampleInputPassword1">
            </div>

            <div class="mb-3 col-6">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" name="confirmPassword" class="form-control" id="confirmPassword">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
	
	</form>
	
</div>


<jsp:include page="include/footer.jsp" />