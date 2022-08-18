<%@page import="com.hospitalmanagement.service.DoctorServiceImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Add Medicine</title>
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
                    <h3 class="text-center my-3">Add Medicine</h3>
            <form action="addmedicine" method="post">
            <div class="row">
                 <div class="form-group">
                     <label for="name">Name</label>
                     <input type="text" class="form-control" id="firstname" aria-describedby="emailHelp" name="name" placeholder="Enter first name.." required>
                 </div>
                 
                  <div class="form-group ml-4">
                  <label for="email">Medicine Type</label>
                   <select name="type" class="form-control">
                       <option value="0">Select Medicine Type</option>
                       <%
                           
                           for(DatabaseConstants.MedicineType medicineType : DatabaseConstants.MedicineType.values())
                           {
                       %>
                             <option value="<%=medicineType.value()%>"><%=medicineType.value() %></option>
                       <%
                           }
                       %>
                   </select>
               </div>
            </div>  
            <div class="row">   
                 <div class="form-group">
                     <label for="date">Manufacture Date</label>
                     <div class="input-group date">
                     <input type="text" class="form-control" id="username" aria-describedby="emailHelp" name="manufacturedate" placeholder="Select Date.." required>
                    
                     </div>
                 </div>
                 
                 <div class="form-group ml-4">
                     <label for="date">Expiry Date</label>
                     <input type="text" class="form-control" id="emailid" aria-describedby="emailHelp" name="expirydate" placeholder="Enter expiry date.." required>
                 </div>
            </div>
            <div class="row">     
                  <div class="form-group">
                     <label for="email">Quantity</label>
                     <input type="number" class="form-control" id="mobileno" aria-describedby="emailHelp" name="quantity" placeholder="Enter quantity.." required>
                 </div>
                 
                 <div class="form-group ml-4">
                     <label for="email">Price</label>
                     <input type="number" class="form-control" id="mobileno" aria-describedby="emailHelp" name="price" placeholder="Enter price.." required>
                 </div>
             </div>   
            <div class="row">     
                  <div class="form-group">
                  <label for="email">Medicine Distributor</label>
                   <select name="distributorid" class="form-control">
                       <option value="0">Select Distributor</option>
                       <%
                           MedicineDistributorResource medicineDistributorResource = (MedicineDistributorResource) request.getAttribute("medicineDistributorResource");
                           List<MedicineDistributor> medicineDistributors = medicineDistributorResource.getAllDistributors();
                           for(MedicineDistributor medicineDistributor : medicineDistributors)
                           {
                       %>
                             <option value="<%=medicineDistributor.getId()%>"><%=medicineDistributor.getName() %></option>
                       <%
                           }
                       %>
                   </select>
                 </div>
                 
                  <div class="form-group ml-4">
                  <label for="email">Medicine Company</label>
                   <select name="companyid" class="form-control">
                       <option value="0">Select Company</option>
                       <%
                           MedicineCompanyResource medicineCompanyResource = (MedicineCompanyResource) request.getAttribute("medicineCompanyResource");
                           List<MedicineCompany> medicineCompanys = medicineCompanyResource.getAllCompanys();
                           for(MedicineCompany medicineCompany : medicineCompanys)
                           {
                       %>
                             <option value="<%=medicineCompany.getId()%>"><%=medicineCompany.getName() %></option>
                       <%
                           }
                       %>
                   </select>
               </div>
             </div>  
             
             <%
                   Date date = new Date();  
                   SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
                   String strDate= formatter.format(date);  
                 %>  
             
             <div class="form-group">
                     <label for="datereg">Medicine Date Added</label>
                     <input type="text" class="form-control" id="datereg" aria-describedby="emailHelp" name="dateAdded" value="<%=strDate%>" readonly required>
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
<script type="text/javascript">
   $(function() {
       $('#datapicker').datepicker();
   });
</script>
</body>
</html>