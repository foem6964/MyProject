<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


<title>Shoppers</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
<link rel="stylesheet" href="/resources/fonts/icomoon/style.css">

<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/magnific-popup.css">
<link rel="stylesheet" href="/resources/css/jquery-ui.css">
<link rel="stylesheet" href="/resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="/resources/css/owl.theme.default.min.css">


<link rel="stylesheet" href="/resources/css/aos.css">

<link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>



	<div class="site-wrap">
		<header class="site-navbar" role="banner">
			<div class="site-navbar-top">
				<div class="container">
					<div class="row align-items-center">

						<div
							class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
							<div class="site-logo">
								<a href="#" class="js-logo-clone">Shoppers</a>
							</div>
						</div>

					</div>
				</div>
			</div>


			<nav class="site-navigation text-right text-md-center"
				role="navigation">
				<div class="container">
					<ul class="site-menu js-clone-nav d-none d-md-block">
						<li class="has-children active"><a href="/">Home</a>
							<ul class="dropdown">
								<li><a href="#">Menu One</a></li>
								<li><a href="#">Menu Two</a></li>
								<li><a href="#">Menu Three</a></li>
								<li class="has-children"><a href="#">Sub Menu</a>
									<ul class="dropdown">
										<li><a href="#">Menu One</a></li>
										<li><a href="#">Menu Two</a></li>
										<li><a href="#">Menu Three</a></li>
									</ul></li>
							</ul></li>
						<li class="has-children"><a href="about.html">About</a>
							<ul class="dropdown">
								<li><a href="#">Menu One</a></li>
								<li><a href="#">Menu Two</a></li>
								<li><a href="#">Menu Three</a></li>
							</ul></li>
						<li><a href="shop.html">Shop</a></li>
						<li><a href="#">Catalogue</a></li>
						<li><a href="#">New Arrivals</a></li>
						<li><a href="contact.html">Contact</a></li>
					</ul>
				</div>



			</nav>
		</header>
		<div class="container">
			<div class="row">
				<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<h5 class="card-title text-center">로그인페이지</h5>
							<h5 class="card-title text-center">${ result }</h5>
							<form class="form-signin" action="/loginPost" method="post">
								<div class="form-label-group">
									<input type="email" id="inputEmail" class="form-control"
										placeholder="Email address" required autofocus> <label
										for="inputEmail"></label>
								</div>
								<button class="btn btn-lg btn-primary btn-block text-uppercase"
									type="submit">Sign in</button>
								<hr class="my-4">
								<h3 class="text-center">간편로그인</h3>
								<div class="text-center" style="border-radius: 1rem;">
									<a href="${ naver_url }"><img width="300"
										src="/resources/images/naver-login.png" alt="Naver Login" /></a>
									<a href="${ kakao_url }"><img width="300"
										src="/resources/images/kakao_login.png" alt="Kakao Login" /></a>
									<a href="${ google_url }"><img width="300"
										src="/resources/images/google-login.png" alt="Google Login" /></a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>





	</div>

<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>

<!--Start of Tawk.to Script-->
<script type="text/javascript">
	var Tawk_API = Tawk_API || {}, Tawk_LoadStart = new Date();
	(function() {
		var s1 = document.createElement("script"), s0 = document
				.getElementsByTagName("script")[0];
		s1.async = true;
		s1.src = 'https://embed.tawk.to/5f2a23435c885a1b7fb667ed/default';
		s1.charset = 'UTF-8';
		s1.setAttribute('crossorigin', '*');
		s0.parentNode.insertBefore(s1, s0);
	})();
</script>
<!--End of Tawk.to Script-->
</html>