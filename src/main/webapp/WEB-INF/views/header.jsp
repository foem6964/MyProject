<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
.carousel-item {
  height: 65vh;
  min-height: 350px;
  background: no-repeat center center scroll;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  }
 .searchbar{
 margin-bottom: auto;
 margin-top: auto;
 height: 60px;
 background-color: white;
 border-radius: 30px;
 padding: 10px;
 }
.search_input{
  color: black;
  border: 0;
  outline: 0;
  background: none;
  width: 0;
  caret-color:black;
  line-height: 40px;
  transition: width 0.4s linear;
 }
.searchbar:hover > .search_input{
 padding: 0 10px;
 width: 450px;
 caret-color:black;
 transition: width 0.4s linear;
 }
.searchbar:hover > .search_icon{
 background: transparent;
 }
.search_icon{
 height: 40px;
 width: 40px;
 float: right;
 display: flex;
 justify-content: center;
 align-items: center;
 border-radius: 50%;
 color:black ;
 text-decoration:none;
 }
</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container">
    <a class="navbar-brand" href="/product/productList">C팡</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        
        <!-- search -->
        <div class="container h-100">
      <div class="d-flex justify-content-center h-100">
        <div class="searchbar">
          <input id="search" class="search_input" type="text" placeholder="Search...">
          <img onclick='document.location.href="productList?searchValue="+search.value' role="button" class="search_icon" src="https://img.icons8.com/ios/24/000000/search--v1.png"/>
        </div>
      </div>
    </div>
    
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <!-- <li class="nav-item active">
          <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
        </li> -->
        <li class="nav-item">
          <a class="nav-link" href="/cart/list"><svg width="2em" height="2em" viewBox="0 0 16 16" class="bi bi-cart3" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  			<path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
			</svg></a>
        </li>
 
        <li class="nav-item">
        	<c:if test="${sessionScope.loginUser ne null}">
				 <a class="nav-link" href="/users/logout"><svg width="2em" height="2em" viewBox="0 0 16 16" class="bi bi-person-check-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  				<path fill-rule="evenodd" d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm9.854-2.854a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L12.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
			</svg></a>
			</c:if>
			<!-- 로그인 된 상태 -->
        	<c:if test="${sessionScope.loginUser eq null}">
				<a class = "nav-link" href="/users/login"><svg width="2em" height="2em" viewBox="0 0 16 16" class="bi bi-person" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
</svg></a>
			</c:if>

        </li>
         <li class="nav-item">
         	<div class = "dropdown">
          <a  class="nav-link" id="linkdown" data-toggle="dropdown" href="#"><svg width="2em" height="2em" viewBox="0 0 16 16" class="bi bi-question-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  			<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  			<path d="M5.25 6.033h1.32c0-.781.458-1.384 1.36-1.384.685 0 1.313.343 1.313 1.168 0 .635-.374.927-.965 1.371-.673.489-1.206 1.06-1.168 1.987l.007.463h1.307v-.355c0-.718.273-.927 1.01-1.486.609-.463 1.244-.977 1.244-2.056 0-1.511-1.276-2.241-2.673-2.241-1.326 0-2.786.647-2.754 2.533zm1.562 5.516c0 .533.425.927 1.01.927.609 0 1.028-.394 1.028-.927 0-.552-.42-.94-1.029-.94-.584 0-1.009.388-1.009.94z"/>
			</svg></a>
			
			<div class="dropdown-menu">
  			  <a class="dropdown-item" href="/userpage/Noticeboardlist">공지사항</a>
  			  <a class="dropdown-item" href="/userpage/faq">FAQ</a>
			  </div>
			</div>
        </li>
       
      </ul>
    </div>
    
  </div>


</nav>

</body>
</html>