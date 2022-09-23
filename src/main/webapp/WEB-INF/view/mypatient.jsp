<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.hospitalmanagement.model.*"%>
<%@ page import ="com.hospitalmanagement.dao.*"%>
<%@ page import ="com.hospitalmanagement.resource.*"%>
<%@ page import ="com.hospitalmanagement.constants.*"%>
<%@page import="com.hospitalmanagement.constants.DatabaseConstants.TreatmentStatus"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.Date"%>
<%@ page import ="java.util.*"%>
<%@ page import ="java.text.SimpleDateFormat"%>
<%@ page import ="java.text.DateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Patients</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="./components/navbar.jsp"%>
<%
    Date date = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
    String strDate= formatter.format(date);  
%>
<div class="row mt-4">
    <div class="col-md-6">
        <div class="card">
            <div class="card-header text-center text-color">
                <h3>Todays Appointment  Date : <%=strDate%> </h3> 
            </div>
            <div class="card-body">
               <div class="table-responsive">
          <table class="table">
  <thead class="custom-bg text-color">
    <tr>
      <th scope="col">Appointment No.</th>
      <th scope="col">Patient Name</th> 
      <th scope="col">Appointment Date</th>
      <th scope="col">Appointment Time</th>
      <th scope="col">Treatment Status</th>
      <th scope="col">Take Action</th> 
    </tr>
  </thead>
  
   <%
      Doctor doctor = (Doctor)session.getAttribute("active-user");
      AppointmentResource appointmentResource = (AppointmentResource) request.getAttribute("appointmentResource"); 
      List<Appointment> appointments = appointmentResource.getAppointmentsByDoctorIdAndAppointmentDate(doctor.getId(),strDate );
      DoctorResource dResource = (DoctorResource)request.getAttribute("doctorResource");
      PatientResource pResource = (PatientResource)request.getAttribute("patientResource");
 
      if(appointments != null) {
    	  
    	  for(Appointment appointment : appointments) {
          Doctor d = dResource.getDoctorById(appointment.getDoctorid());
          Patient p = pResource.getPatientById(appointment.getPatientid());
       
        
    %> 
  <tbody>
    <tr class="text-center">
      <td class="mid-align"><%=appointment.getId()%></td>
      <td class="mid-align"><%=p.getFirstname() %></td>
      <td class="mid-align"><%=appointment.getAppointmentdate() %></td>
      <td class="mid-align"><%=appointment.getAppointmenttime() %></td>
      <td class="mid-align <%if(TreatmentStatus.DONE.value().equals(appointment.getTreatmentstatus())) { %>text-success <% } else if(TreatmentStatus.PENDING.value().equals(appointment.getTreatmentstatus())) { %> text-danger <% }%>"><%=appointment.getTreatmentstatus()%></td>
      <td class="mid-align">
          <a href="viewappoinment?appointmentId=<%=appointment.getId()%>"><button type="button"
             class="btn custom-bg text-color">View</button></a>
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
        </div>
    </div>
    <div class="col-md-6">
        <div class="card">
            <div class="card-header text-center text-color">
                <h3>Search Appointments</h3> 
            </div>
            <div class="card-body">
               <form class="form-inline ml-5" action="searchappointmentbydateandtime">
                 <div class="form-group">
                  <label for="inputPassword2" class="text-color"><h5>Search Appointments</h5></label>
                  <input type="text" class="form-control mr-1 ml-2" id="inputPassword2" name="date" placeholder="Enter Date..">
                  <select name="time" class="form-control ml-2">
                       <option value="0">Select Timing</option>
                      <%
                           
                           for(DatabaseConstants.AppointmentTiming timings : DatabaseConstants.AppointmentTiming.values())
                           {
                       %>
                             <option value="<%=timings.value()%>"><%=timings.value() %></option>
                       <%
                           }
                       %>
                   </select>
                 </div>
                       <button type="submit" class="btn text-color custom-bg ml-2">Search</button>
              </form>
              <div class="table-responsive mt-4">
          <table class="table">
  <thead class="custom-bg text-color">
    <tr>
      <th scope="col">Appointment No.</th>
      <th scope="col">Patient Name</th> 
      <th scope="col">Appointment Date</th>
      <th scope="col">Appointment Time</th>
      <th scope="col">Treatment Status</th>
      <th scope="col">Take Action</th> 
   
    </tr>
  </thead>
  
   <%
      List<Appointment> apmts = (List<Appointment>)request.getAttribute("appointments");
 
      if(apmts != null) {
    	  
    	  for(Appointment appointment : apmts) {
          Doctor d = dResource.getDoctorById(appointment.getDoctorid());
          Patient p = pResource.getPatientById(appointment.getPatientid());
      
    %> 
  <tbody>
    <tr class="text-center">
      <td class="mid-align"><%=appointment.getId()%></td>
      <td class="mid-align"><%=p.getFirstname() %></td>
      <td class="mid-align"><%=appointment.getAppointmentdate() %></td>
      <td class="mid-align"><%=appointment.getAppointmenttime() %></td>
      <td class="mid-align <%if(TreatmentStatus.DONE.value().equals(appointment.getTreatmentstatus())) { %>text-success <% } else if(TreatmentStatus.PENDING.value().equals(appointment.getTreatmentstatus())) { %> text-danger <% }%>"><%=appointment.getTreatmentstatus()%></td>
      <td class="mid-align">
          <a href="viewappoinment?appointmentId=<%=appointment.getId()%>"><button type="button"
             class="btn custom-bg text-color">View</button></a>
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
        </div>
    </div>
</div>  
</body>
</html>