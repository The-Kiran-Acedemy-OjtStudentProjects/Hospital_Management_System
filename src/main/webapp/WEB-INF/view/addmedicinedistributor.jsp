<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import ="com.hospitalmanagement.model.*"%>
<%@ page import ="com.hospitalmanagement.dao.*"%>
<%@ page import ="com.hospitalmanagement.resource.*"%>
<%@ page import ="com.hospitalmanagement.constants.*"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.Date"%>
<%@ page import ="java.util.*"%>
<%@ page import ="java.text.SimpleDateFormat"%>
<%@ page import ="java.text.DateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Medicine Distributor</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="./components/navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-2">
       <div class="col-md-4 offset-md-4 admin" >
            <div class="card">
                <%@ include file="./components/message.jsp"%>
                <%
		Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	String strDate = formatter.format(date);
	%>
                <div class="card-body px-5">
                    <h3 class="text-center my-3">Register Medicine Distributor</h3>
            <form action="addmedicinedistributor" method="post">
            <div class="row">
                 <div class="form-group">
                     <label for="name">Name</label>
                     <input type="text" class="form-control" id="firstname" aria-describedby="emailHelp" name="name" placeholder="Enter name.." required>
                 </div>
                 
                  <div class="form-group ml-4">
                     <label for="name">Email Id</label>
                     <input type="email" class="form-control" id="lastname" aria-describedby="emailHelp" name="emailid" placeholder="Enter email id.." required>
                 </div>
            </div>  
            <div class="row">   
                 <div class="form-group">
                     <label for="email">Mobile No</label>
                     <input type="text" class="form-control" id="username" aria-describedby="emailHelp" name="mobileno" placeholder="Enter mobile no.." required>
                 </div>
                 
                 <div class="form-group ml-4">
                     <label for="name">Street</label>
                     <input type="text" class="form-control" id="street" aria-describedby="emailHelp" name="street" placeholder="Enter street.." required>
                 </div>
            </div>
             <div class="row">
                 <div class="form-group">
                     <label for="name">City</label>
                     <input type="text" class="form-control" id="city" aria-describedby="emailHelp" name="city" placeholder="Enter city.." required>
                 </div>
                 
                 <div class="form-group   ml-4">
                     <label for="email">Pin code</label>
                     <input type="number" class="form-control" id="pincode" aria-describedby="emailHelp" name="pincode" placeholder="Enter pincode.." required>
                 </div>
              </div>
              
              <div class="form-group">
                     <label for="name">Register Date</label>
                     <input type="text" class="form-control" id="street" aria-describedby="emailHelp" name="registerdate" value="<%=strDate %>" required>
                 </div>
                <div class="container text-center">
                      <button class="btn custom-bg text-color"><b>Register Distributor</b></button>
                 </div>
                 
            </form>
                </div>
            </div>
           
            
       </div>
  </div>
</div>
</body>
</html>