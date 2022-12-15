<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<div class="container g-0 d-flex align-items-center">
    <div class="col-6">
      <div class="card-body py-5 px-md-5">
        <h2>Sign In</h2>

        <form action="/signinpost" method="POST">
          <!-- username input -->
          <div class="form-outline mb-4">
            <input type="text" id="username-login" class="form-control" name="username"/>
            <label class="form-label" for="username-login">Username</label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
            <input type="password" id="password-login" class="form-control" name="password"/>
            <label class="form-label" for="password-login">Password</label>
          </div>

          <!-- 2 column grid layout for inline styling -->
          <!-- password Reset-->
          <!--<div class="row mb-4">
            <div class="col">
              <a href="www.example.com">Forgot password?</a>
            </div>
          </div>-->

          <!-- Submit button -->
          <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

        </form>

      </div>
    </div>
<!--
    <div class="col-6">
      <img src="images/pexels-eberhard-grossgasteiger-572897.jpg" alt="Mountain against background of night scky with stars" style="max-width: 100%;height: auto;">
    </div>
-->
</div>

<jsp:include page="include/footer.jsp" />