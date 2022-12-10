<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.hospitalmanagement.model.*"%>
<%@ page import ="com.hospitalmanagement.dao.*"%>
<%@ page import ="com.hospitalmanagement.resource.*"%>
<%@ page import ="com.hospitalmanagement.constants.*"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Medicine</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="./components/navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-4">
       <form class="form-inline ml-5" action="searchmedicinebyid">
          <div class="form-group">
            <label for="inputPassword2" class="text-color"><h4>Search Medicine By Id</h4></label>
            <input type="number" class="form-control ml-3" id="inputPassword2" name="medicineId" placeholder="Enter Medicine Id..">
          </div>
          <button type="submit" class="btn text-color custom-bg ml-2">Search</button>
       </form>
       <form class="form-inline mt-1" action="searchmedicinebyname">
          <div class="form-group">
            <label for="inputPassword2" class="text-color ml-5"><h4>Search Medicine By Name</h4></label>
            <input type="text" class="form-control ml-3" id="inputPassword2" name="medicineName" placeholder="Enter Medicine name..">
          </div>
          <button type="submit" class="btn text-color custom-bg ml-2">Search</button>
       </form>
       <a href="totalMedicines" class="ml-2"><button class="btn text-color custom-bg ml-2">Total Medicines</button></a>
       <a href="expiredMedicines" class="ml-2"><button class="btn text-color custom-bg ml-2">Expired Medicines</button></a> 
  </div>
  <div class="table-responsive">
          <table class="table">
  <thead class="custom-bg text-color">
    <tr>
      <th scope="col">Medicine Id</th>
      <th scope="col">Medicine Name</th> 
      <th scope="col">Medicine Type</th>    
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
      <th scope="col">Company</th>
      <th scope="col">Distributor</th>
      <th scope="col">Manufacture Date</th>
      <th scope="col">Expiry Date</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  
   <%
      List<Medicine> listOfMedicines = (List<Medicine>)request.getAttribute("medicines");
      MedicineResource medicineResource = (MedicineResource)request.getAttribute("medicineResource");
      MedicineCompanyResource medicineCompanyResource = (MedicineCompanyResource)request.getAttribute("medicineCompanyResource");
      MedicineDistributorResource medicineDistributorResource = (MedicineDistributorResource)request.getAttribute("medicineDistributorResource");

      if(listOfMedicines != null) {
          for(Medicine m : listOfMedicines) {
        	  MedicineCompany c = medicineCompanyResource.getCompanyById(m.getCompanyid());
              MedicineDistributor d = medicineDistributorResource.getDistributorById(m.getDistributorid());
                
            %> 
          <tbody>
            <tr class="text-center">
              <td class="mid-align"><%=m.getId()%></td>
              <td class="mid-align"><%=m.getName() %></td>
              <td class="mid-align"><%=m.getType() %></td>
              <td class="mid-align"><%=m.getPrice() %></td>
              <td class="mid-align <% if(m.getQuantity() == 0){ %> text-danger <% } %>"><% if(m.getQuantity() == 0){ %>Out Of Stock <% } else {%><%=m.getQuantity()%><% } %></td>
              <td class="mid-align"><%=c.getName()%></td>
              <td class="mid-align"><%=d.getName() %></td>
              <td class="mid-align"><%=m.getManufacturedate() %></td>
              <td class="mid-align"><%=m.getExpirydate() %></td>
              <td class="mid-align"><a href="updateMedicine?medicineId=<%=m.getId()%>"><button type="button"
                  class="btn custom-bg text-color">Edit Medicine</button></a>
              </td>
            </tr>
          </tbody>
    <%
          }
      }
    %>
</table>
   </div>
</div>

</body>
</html>