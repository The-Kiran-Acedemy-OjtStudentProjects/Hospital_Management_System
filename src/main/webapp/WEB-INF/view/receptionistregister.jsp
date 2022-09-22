<%@page import="com.hospitalmanagement.service.DoctorServiceImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Receptionist Register</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="./components/navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-2">
       <div class="col-md-4 offset-md-4 admin" >
            <div class="card">
                <%@ include file="./components/message.jsp"%>
                <div class="card-body px-5">
                    <img src="resources/images/registerphoto.jpeg" class="rounded mx-auto d-block" alt="img" height="90px" width="90px">
                    <h3 class="text-center my-3">Register Receptionist</h3>
            <form action="receptionistregister" method="post">
            <div class="row">
                 <div class="form-group ml-4">
                     <label for="name">First Name</label>
                     <input type="text" class="form-control" id="firstname" aria-describedby="emailHelp" name="firstname" placeholder="Enter first name.." required>
                 </div>

                  <div class="form-group ml-4">
                     <label for="name">Last Name</label>
                     <input type="text" class="form-control" id="lastname" aria-describedby="emailHelp" name="lastname" placeholder="Enter last name.." required>
                 </div>
            </div>
            <div class="row">
                 <div class="form-group ml-4">
                     <label for="email">Email</label>
                     <input type="email" class="form-control" id="emailid" aria-describedby="emailHelp" name="emailid" placeholder="Enter email id.." required>
                 </div>
                 <div class="form-group ml-4">
                     <label for="email">Username</label>
                     <input type="text" class="form-control" id="emailid" aria-describedby="emailHelp" name="username" placeholder="Enter username.." required>
                 </div>
            </div>
            <div class="row">
                  <div class="form-group ml-4">
                     <label for="email">Age</label>
                     <input type="number" class="form-control" id="mobileno" aria-describedby="emailHelp" name="age" placeholder="Enter age.." required>
                  </div>
                  <div class="form-group ml-4">
                     <label for="email">Street</label>
                     <input type="text" class="form-control" id="street" aria-describedby="emailHelp" name="street" placeholder="Enter Street.." required>
                  </div>
             </div>
             <div class="row">
                 <div class="form-group ml-4" >
                     <label for="name">City</label>
                     <input type="text" class="form-control" id="city" aria-describedby="emailHelp" name="city" placeholder="Enter city.." required>
                 </div>

                 <div class="form-group   ml-4">
                     <label for="email">Pin code</label>
                     <input type="number" class="form-control" id="pincode" aria-describedby="emailHelp" name="pincode" placeholder="Enter pincode.." required>
                 </div>
              </div>
              <div class="row">
                  <div class="form-group ml-4" >
                     <label for="email">Mobile No.</label>
                     <input type="number" class="form-control" id="password" aria-describedby="emailHelp" name="mobileno" placeholder="Enter mobile no.." required>
                 </div>

                  <div class="form-group ml-4">
                     <label for="name">Password</label>
                     <input type="password" class="form-control" id="password" aria-describedby="emailHelp" name="password" placeholder="Enter password.." required>
                 </div>
             </div>
             <%
                   Date date = new Date();
                   SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                   String strDate= formatter.format(date);
                 %>
               <div class="row">
                 <div class="form-group ml-4">
                     <label for="rdate">Registered Date</label>
                     <input type="text" class="form-control" id="rdate" aria-describedby="emailHelp" name="registerdate" value="<%=strDate%>" readonly required>
                 </div>
               </div>     
                <div class="container text-center">
                      <button class="btn custom-bg text-color"><b>Register</b></button>
                </div>
                 
            </form>
                </div>
            </div>
           
       </div>
  </div>
</div>
</body>
</html>