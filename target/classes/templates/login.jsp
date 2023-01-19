<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Login Page</title>
<link href="webjars/bootstrap/4.6.0/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
<style>
.login-form {
	width: 400px;
	height: 275px;
	background-color: #34568B;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%);
}
</style>
</head>

<body>

	<div class="login-form">

		<div class="container-fluid">
			<form method="post" action="login">

				<div class="mt-3">
					<input type="text" class="form-control" name="userId"
						placeholder="User ID" />
				</div>
				<div class="mt-3">
					<input type="password" class="form-control" name="password"
						placeholder="Password" />
				</div>
				<button type="submit" class="btn btn-dark btn-block mt-3">Login</button>

				<div class="mt-3">
					<a href="/register" class="btn btn-success btn-block mt-3">Register</a>
				</div>

			</form>
		</div>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.2/js/toastr.min.js">
		
	</script>

	<script>
		window.onload = function() {
			if ("${errorMsg}" != "") {
				Command: toastr["error"]("${errorMsg}")

				toastr.options = {
					"closeButton" : false,
					"debug" : false,
					"newestOnTop" : false,
					"progressBar" : false,
					"positionClass" : "toast-top-right",
					"preventDuplicates" : false,
					"onclick" : null,
					"showDuration" : "5000",
					"hideDuration" : "1000",
					"timeOut" : "5000",
					"extendedTimeOut" : "1000",
					"showEasing" : "swing",
					"hideEasing" : "linear",
					"showMethod" : "fadeIn",
					"hideMethod" : "fadeOut"
				}
			}

		}
	</script>
</body>

</html>