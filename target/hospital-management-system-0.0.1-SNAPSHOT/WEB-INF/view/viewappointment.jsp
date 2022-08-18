<%@page import="com.hospitalmanagement.service.DoctorServiceImp"%>
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
<title>View Appointment</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="./components/navbar.jsp"%>
<%@ include file="./components/message.jsp"%>
<%
     DoctorResource dResource = (DoctorResource)request.getAttribute("doctorResource");
     PatientResource pResource = (PatientResource)request.getAttribute("patientResource");
     Appointment appointment = (Appointment)request.getAttribute("appointment");
     Patient patient = pResource.getPatientById(appointment.getPatientid());
%>
<div class="container-fluid">
  <div class="row mt-2">
       <div class="col-md-4 mx-auto" >
            <div class="card card-border mx-auto" style="width: 35rem;">
                
                <div class="card-body px-5 mx-auto">
                    <h3 class="text-center my-3">View Appointment</h3>
                    <div class="container">
            <form action="updateappointment">
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
             
             <div class="form-group">
                  <label for="email">Treatment Status</label>
                   <select name="treatmentStatus" class="form-control">
                       <option value="0">Select Status</option>
                      <%   
                           for(DatabaseConstants.TreatmentStatus tStatus : DatabaseConstants.TreatmentStatus.values())
                           {
                       %>
                             <option value="<%=tStatus.value()%>"><%=tStatus.value() %></option>
                       <%
                           }
                       %>
                   </select>
             </div>  
             
             <div class="form-group">
                  <label for="email">Treatment Price</label>
                  <input type="number" class="form-control" aria-describedby="emailHelp" name="treatmentprice" required>
             </div>
            
                                      
             <div class="container text-center">
                 <button class="btn custom-bg text-color"><b>Update Appointment</b></button>
             </div>  
           
            </form>
            </div>
            
            <h3 class="text-center my-3">Assign Medicine to patient</h3>
            <div class="container mx-auto">
                 <form class="form-inline" action="assignMedicinesToPatient" method="post">
                 <input type="hidden" name="appointmentId" value="<%=appointment.getId()%>"> 
                     <div class="form-group">
                 
                   <select name="medicineId" class="form-control" style="width: 22rem;">
                       <option value="0">Select Medicines</option>
                       <%
                           MedicineResource medicineResource = (MedicineResource) request.getAttribute("medicineResource");
                           List<Medicine> medicines = medicineResource.getAllAvailableMedicines();
                           for(Medicine medicine : medicines)
                           {
                       %>
                             <option value="<%=medicine.getId()%>"><%=medicine.getName()+" " %><%=medicine.getType() %></option>
                       <%
                           }
                       %>
                   </select>
                 </div>
                 
                 <button type="submit" class="btn text-color custom-bg ml-2">Add</button>
                 <% 
                    List<Medicine> mds = (List<Medicine>)request.getAttribute("medicines");
                 %>
                 
                 <div class="form-group mt-2">
                   <textarea class="form-control" id="exampleFormControlTextarea1" rows="6" cols="49" required readonly>
                      <% if(mds != null)
                         {
                    	    for(Medicine m : mds)	
                    	    {
                      %>
                               <%=m.getName()+", " %>
                      <%
                    	    }
                         }
                      %>                      
                   </textarea>
                 </div>
                     
                 </form>
                                
            </div>
            
            <div class="container-fluid text-center mt-2">
                     <a href="assignMedicinesToPatientDB?appointmentId=<%=appointment.getId()%>"><button class="btn custom-bg text-color">Assign Medicines to Patient</button></a>
                  </div>
              
                </div>
            </div>
           
       </div>
  </div>
</div>
</body>
</html>