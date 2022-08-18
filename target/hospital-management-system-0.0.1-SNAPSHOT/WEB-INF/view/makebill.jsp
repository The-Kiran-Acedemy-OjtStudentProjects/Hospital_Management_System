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
<title>Make Bill</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="./components/navbar.jsp"%>
<%
     DoctorResource dResource = (DoctorResource)request.getAttribute("doctorResource");
     PatientResource pResource = (PatientResource)request.getAttribute("patientResource");
     Appointment appointment = (Appointment)request.getAttribute("appointment");
     MedicineResource mResource = (MedicineResource)request.getAttribute("medicineResource");
     Patient patient = pResource.getPatientById(appointment.getPatientid());
%>
<div class="container-fluid">
  <div class="row mt-2">
       <div class="col-md-4 mx-auto" >
            <div class="card card-border mx-auto" style="width: 35rem;">
                <%@ include file="./components/message.jsp"%>
                <div class="card-body px-5 mx-auto">
                    <h3 class="text-center my-3">Appointment Detail</h3>
                <div class="container">    
            <form action="bill">
            <input type="hidden" name="appointmentId" value="<%=appointment.getId()%>">
            
            <div class="row">   
                 <div class="form-group">
                     <label for="email">Patient First Name</label>
                     <input type="email" class="form-control" aria-describedby="emailHelp" value="<%= patient.getFirstname() %>" readonly required>
                 </div>
                 
                 <div class="form-group ml-2">
                     <label for="email">Patient Last Name</label>
                     <input type="email" class="form-control" aria-describedby="emailHelp" value="<%= patient.getLastname() %>" readonly required>
                 </div>
                 
            </div>
            <div class="row">     
                 <div class="form-group">
                     <label for="email">Patient Blood Group</label>
                     <input type="text" class="form-control" aria-describedby="emailHelp"  value="<%=patient.getBloodgroup()%>"  readonly required>
                 </div>
                 
                 <div class="form-group ml-2">
                     <label for="email">Patient Age</label>
                     <input type="text" class="form-control" aria-describedby="emailHelp" value="<%= patient.getAge()%>" readonly required>
                 </div> 
             </div>   
            
              <div class="row">     
                  <div class="form-group">
                     <label for="email">Appointment Date</label>
                     <input type="text" class="form-control" aria-describedby="emailHelp" value="<%=appointment.getAppointmentdate() %>" required readonly>
                 </div>
                  <div class="form-group ml-2">
                     <label for="email">Appointment Time</label>
                     <input type="text" class="form-control" aria-describedby="emailHelp" value="<%=appointment.getAppointmenttime() %>" required readonly>
                 </div>
             </div>  
             
             <div class="form-group">
                 <label for="exampleFormControlTextarea1">Problem Description</label>
                 <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" required readonly><%=appointment.getProblemdescription() %></textarea>
             </div>
             
             <%
                 List<Medicine> mds = appointment.getMedicines();
             %>
             
            <div class="form-group">
                   <label for="exampleFormControlTextarea1">Assigned Medicines</label>
                   <textarea class="form-control" id="exampleFormControlTextarea1" rows="4" readonly>
                      <% if(mds != null)
                         {
                    	    for(Medicine m : mds)	
                    	    {
                      %>
                               <%=m.getName()+"," %>
                      <%
                    	    }
                         }
                      %>                      
                   </textarea>
                 </div>
             
                 <div class="form-group">
                     <label for="email">Treatment Status</label>
                     <input type="text" class="form-control" aria-describedby="emailHelp" value="<%=appointment.getTreatmentstatus() %>" required readonly>
                 </div>
              
                 <div class="form-group">
                     <label for="email">Treatment Price</label>
                     <input type="text" class="form-control" aria-describedby="emailHelp" value="<%=appointment.getTreatmentprice() %>" required readonly>
                 </div>
                 
                 <div class="form-group">
                     <label for="email">Total Medicines Price</label>
                     <input type="text" class="form-control" aria-describedby="emailHelp" value="<%=mResource.getMedicinesPrice(mds) %>" required readonly>
                 </div>
                 
                 <div class="form-check">
                     <label class="form-check-label" for="exampleCheck1">Want Medicines from hospital</label><br>
                     <input type="checkbox" class="form-check-input" id="exampleCheck1" name="iswantmedicine" value="<%=DatabaseConstants.WantMedicinesFromHospital.YES.value()%>">
                     <label>Yes</label><br>
                     <input type="checkbox" class="form-check-input" id="exampleCheck1" name="iswantmedicine" value="<%=DatabaseConstants.WantMedicinesFromHospital.NO.value()%>">
                     <label>No</label>
                 </div>
                 
                                      
             <div class="container text-center">
                 <button class="btn custom-bg text-color"><b>Make Bill</b></button>
             </div>  
                            
            </form>
            </div>
            </div>
            </div>
              
                </div>
            </div>
           
       </div>
  

</body>
</html>