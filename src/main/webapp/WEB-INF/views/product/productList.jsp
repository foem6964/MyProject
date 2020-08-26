<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>

<title>product</title>
</head>
<body>
<%@ include file = "/WEB-INF/views/header.jsp" %>




  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      <!-- Slide One - Set the background image for this slide in the line below -->
      <div class="carousel-item active" style="background-image: url('https://i.pinimg.com/originals/3b/8a/d2/3b8ad2c7b1be2caf24321c852103598a.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3 class="display-4">First Slide</h3>
          <p class="lead">This is a description for the first slide.</p>
        </div>
      </div>
      <!-- Slide Two - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('https://free4kwallpapers.com/uploads/originals/2019/05/18/firewatch-wallpaper.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3 class="display-4">Second Slide</h3>
          <p class="lead">This is a description for the second slide.</p>
        </div>
      </div>
      <!-- Slide Three - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('https://3.bp.blogspot.com/-pMP941Bbvw0/XD4zZMLijpI/AAAAAAAAAno/qYjUr5a_g54AY--4E9KM6FooxcYFnTF2ACKgBGAs/w0/minimalist-forest-river-art-1-4k.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3 class="display-4">Third Slide</h3>
          <p class="lead">This is a description for the third slide.</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
  </div><br>
<!-- Page Content
<section class="py-5">
  <div class="container">
    <h1 class="font-weight-light">Half Page Image Slider</h1>
    <p class="lead">The background images for the slider are set directly in the HTML using inline CSS. The images in this snippet are from <a href="https://unsplash.com">Unsplash</a>!</p>
  </div>
</section> -->

		<div class="container invisible" id="container">
		
			 <div class="row">
	
				<div class="col-sm-4">
					<div class="card">
						<div class="card-body">
							<div class="text-center" style="margin: auto">
								<div id="image"></div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-sm-2"></div>
	
				<div class="col-sm-4">
					<div class="card">
						<div class="card-body">
							<h2 id="pname"></h2>   
							<br>
							<h1 id="SalePrice"></h1>
						</div>
					</div>
				</div>
				
		</div>
	</div>

		<div class="text-center">
			<h3 id="no"></h3>
			<h3 id="ne"></h3>
		</div>
		
</body>
<%@ include file="/WEB-INF/views/footer.jsp"%>
<script type="text/javascript">
		
		function loadDoc(value = '${searchValue}') {
		let req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				//console.log(this);
				//console.log(this.response);
				myFunction(this);
			}
		};
		req.open("GET", 
				 "https://thingproxy.freeboard.io/fetch/https://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=4a972a13f9e22b164bbe473d226d2dd3&apiCode=ProductSearch"
				 +"&keyword=" + value
				 ,true);
		req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
		req.send();
		}

		
	function myFunction(xml) {
		let i;
		let xmlDoc = xml.responseXML;

		let product = xmlDoc.getElementsByTagName("Product"); //확인됨

		let container = document.getElementById("container");

		document.getElementById("container").setAttribute("class", "container");

		//let price = xmlDoc.getElementsByTagName("ProductPrice")[0].firstChild.data;

		//let image1 = xmlDoc.getElementsByTagName("ProductImage300")[0].firstChild.data;
		
		container.innerHTML = '';
		
		if(product.length == 0){ //검색결과 없을때
			document.getElementById("no").innerHTML = "*"+search.value+"*"+" 에대한 검색결과가 없습니다";
			document.getElementById("ne").innerHTML = "새로고침 하거나 다시 검색하세요";
		} 

		let str = '';
		
		for (i = 0; i < product.length; i++) {

			let code = xmlDoc.getElementsByTagName("ProductCode")[i].firstChild.data;
			
			let pname = xmlDoc.getElementsByTagName("ProductName")[i].firstChild.data;
			//document.getElementById("pname").innerHTML = pname;

			let SalePrice = xmlDoc.getElementsByTagName("SalePrice")[i].firstChild.data;
			//document.getElementById("SalePrice").innerHTML = SalePrice;

			let image = xmlDoc.getElementsByTagName("ProductImage170")[i].firstChild.data;
			//var img = document.createElement("img"); 
			//img.setAttribute("src", image);
			//document.getElementById("image").append(img);

 			str += '<div class="card mb-5" style="width:200px; hight:400px;">'
					 + '<div id=image>'
				   		 + '<img class="card-img-top" src="'+image+'">'
				 	 + '</div>'
				    + '<div class="card-body" style="text-align: center">'
				      + '<p class="card-title" id="pname">'
					  + '<a href="productInfo?'
					  + 'ProductCode='+code+''
					  + '">'	  	  	
				      + pname + '</a></p>'
				      + '<h4 id="Saleprice" class="card-text">'
				      + SalePrice + '원</h4>'
				    + '</div>'
				  + '</div>';

		}
		container.innerHTML += '<div class="row d-flex justify-content-between mb-5">'+str+'</div>'; 
	}

	document.addEventListener('DOMContentLoaded', () => {
		//console.log('DOMContentLoaded !!');
		loadDoc();

		let search = document.getElementById('search');
		// console.log('search.value', search.value);
		
		search.addEventListener("keyup", event => { //검색창에 엔터 키 입력시 검색 시작 기능
		  if (event.keyCode === 13) {
			  //console.log('엔터입력!!', event.keyCode);
			  loadDoc(search.value);
		  }
		}); 
	});
</script>


</html>