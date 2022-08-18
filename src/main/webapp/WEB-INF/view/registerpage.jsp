<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
	<%@ include file="./components/navbar.jsp"%>
	<div id="carouselExampleControls" class="carousel slide"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" src="resources/images/car2.jpg"
					alt="First slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="resources/images/car1.jpg"
					alt="Second slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="resources/images/car3.jpg"
					alt="Third slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleControls"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleControls"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<div class="text-center">
		<h2 class="text-color">Start thinking wellness not illness</h2>
	</div>
	
	<div class="row">
    <div class="col-sm-3">
        <div class="card custom-bg ml-5 mr-3 mb-5">
    <img class="card-img-top img-responsive rounded mx-auto d-block" style="height: 15rem; max-width:80%; max-height:auto" src="resources/images/adminpic.png" alt="img" >
    <div class="card-body">
      <a href="/adminregister" class="card-title non-underline-link text-color non-underline-link"><h2 class="card-title text-center text-color">Admin Register</h2></a>
      <p class="card-text">Administrator will monitor all Users.</p>
    </div>
  </div>
    </div>
    <div class="col-sm-3">
        <div class="card custom-bg ml-5 mr-3 mb-5">
    <img class="card-img-top rounded mx-auto d-block" style="height: 15rem; max-width:80%; max-height:auto" src="resources/images/doctorpic.png" alt="img" >
    <div class="card-body">
      <a href="/doctorregister" class="card-title non-underline-link text-color non-underline-link"><h2 class="card-title text-center text-color">Doctor Register</h2></a>
      <p class="card-text">Doctor will treat patient.</p>
    </div>
  </div>
    </div>
    <div class="col-sm-3">
        <div class="card custom-bg ml-5 mr-3 mb-5">
    <img class="card-img-top rounded mx-auto d-block" style="height: 15rem; max-width:80%; max-height:auto" src="resources/images/pharmacistpic.png" alt="img" >
    <div class="card-body">
      <a href="/pharmacistregister" class="card-title non-underline-link text-color non-underline-link"><h2 class="card-title text-center text-color">Pharmacist Register</h2></a>
      <p class="card-text">Pharmacist will handle Medicines.</p>
    </div>
  </div>
    </div>
    <div class="col-sm-3">
        <div class="card custom-bg ml-5 mr-3 mb-5">
    <img class="card-img-top rounded mx-auto d-block mt-1" src="resources/images/receptionistpic.png" alt="img" >
    <div class="card-body">
      <a href="/receptionistregister" class="card-title non-underline-link text-color non-underline-link"><h2 class="card-title text-center text-color">Reception Register</h2></a>
      <p class="card-text">Receptionist will register, make bill for patient.</p>                                                                                          
    </div>
  </div>
    </div>
</div>  
</body>
</html>