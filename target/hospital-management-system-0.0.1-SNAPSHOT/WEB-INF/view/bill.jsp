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
<%@ page import ="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="./components/navbar.jsp"%>
<%
     DoctorResource dResource = (DoctorResource)request.getAttribute("doctorResource");
     PatientResource pResource = (PatientResource)request.getAttribute("patientResource");
     Appointment appointment = (Appointment)request.getAttribute("appointment");
     MedicineResource mResource = (MedicineResource)request.getAttribute("medicineResource");
     MedicineCompanyResource mcResource = (MedicineCompanyResource)request.getAttribute("medicineCompany");
     Patient patient = pResource.getPatientById(appointment.getPatientid());
     Doctor doctor = dResource.getDoctorById(appointment.getDoctorid());
     
%>
  <div class="offset-xl-2 col-xl-8 col-lg-12 col-md-12 col-sm-12 col-12 mt-4 padding">
     <div class="card card-border">
         <div class="card-header p-4">
             <img src="resources/images/logo.png" class="rounded mx-auto pt-2 d-inline-block" alt="img" height="70px" width="70px">
           <!--   <a class="pt-2 d-inline-block" href="index.html" data-abc="true">BBBootstrap.com</a> -->
                 
             <div class="float-right">
                 <h3 class="mb-0 text-color">Appointment Id: <%=appointment.getId()%></h3>
                Billing Date: <%=appointment.getBillingDate() %>
             </div>
         </div>
         <div class="card-body">
             <div class="row mb-4">
                 <div class="col-sm-6">
                     <h2 class="mb-3 text-color">Patient Detail:</h2>
                     <h3 class="text-dark mb-1">Name: <%=patient.getFirstname()+" "%><%=patient.getLastname() %></h3>
                     <div>Age: <%=patient.getAge() %></div>
                     <div>Bloog Group: <%=patient.getBloodgroup() %></div>
                     <div>Email: <%=patient.getEmailid() %></div>
                     <div>Phone: +91 <%=patient.getMobileno() %></div>
                 </div>
                 <div class="col-sm-6 ">
                     <h2 class="mb-3 text-color">Doctor Detail:</h2>
                     <h3 class="text-dark mb-1">Name: <%=doctor.getFirstname()+" "%><%=doctor.getLastname()%></h3>
                     <div>Specialist: <%=doctor.getSpecialist() %></div>
                 </div>
             </div>
             
             <%
                 List<Medicine> medicines = appointment.getMedicines();
             %>
             <div class="text-center text-color"><h2>Assigned Medicines</h2></div>
             <div class="table-responsive-sm mt-3">
                 <table class="table table-striped">
                     <thead class="custom-bg">
                         <tr class="text-color">
                             <th>Medicine Name</th>
                             <th>Type</th>
                             <th>Company</th>
                             <th>Expiry Date</th>
                             <th>Qty</th>
                             <th>Price</th>
                         </tr>
                     </thead>
                    <%
                      for(Medicine m : medicines) { 
                    %>
                     <tbody>
                         <tr>
                             <td><%=m.getName()%></td>
                             <td><%=m.getType() %></td>
                             <td><%=mcResource.getCompanyById(m.getCompanyid()).getName() %></td>
                             <td><%=m.getExpirydate()%></td>
                             <td><%=m.getQuantity() %></td>
                             <td><%=m.getPrice() %></td>
                         </tr>
                     </tbody>
                    <%
                        }
                    %>
                 </table>
             </div>
             <div class="row">
                 <div class="col-lg-4 col-sm-5">
                 </div>
                 <div class="col-lg-4 col-sm-5 ml-auto">
                     <table class="table table-clear">
                         <tbody>
                             <tr>
                                 <td class="left">
                                     <strong class="text-color">Medicines from Hospital:</strong>
                                 </td>
                                 <td class="right"><b><%=appointment.getWantMedicine() %></b></td>
                             </tr>
                             <tr>
                                 <td class="left">
                                     <strong class="text-color">Medicines Price</strong>
                                 </td>
                                 <td class="right"><b>&#8377;<%if(appointment.getWantMedicine().equals(DatabaseConstants.WantMedicinesFromHospital.YES.value())) {%><%=mResource.getMedicinesPrice(medicines) %>
                                 <% }
                                    else { %>
                                      0.0
                                    <% } %>
                                    </b>
                                 </td>
                             </tr>
                             <tr>
                                 <td class="left">
                                     <strong class="text-color">Treatment Price</strong>
                                 </td>
                                 <td class="right"><b>&#8377;<%=appointment.getTreatmentprice() %></b></td>
                             </tr>
                             <tr>
                                 <td class="left">
                                     <strong class="text-color">Total Price</strong>
                                 </td>
                                 <td class="right"><b>&#8377;<%if(appointment.getWantMedicine().equals(DatabaseConstants.WantMedicinesFromHospital.YES.value())) {%><%=mResource.getTotalPrice(mResource.getMedicinesPrice(medicines),String.valueOf(appointment.getTreatmentprice()))%><%
                                         }
                                  else {
                                  %>
                                   <%=mResource.getTotalPrice("0.0", String.valueOf(appointment.getTreatmentprice())) %>
                                  <% 
                                     }
                                  %>
                                  </b>
                                  </td>
                             </tr>
                         </tbody>
                     </table>
                 </div>
             </div>
         </div>
         <div class="card-footer bg-white text-center">
             <a href="downloadBill?appointmentId=<%=appointment.getId()%>"><button type="button"
             class="btn custom-bg text-color">Download Bill</button></a>
         </div>
     </div>
 </div>
</body>
</html>