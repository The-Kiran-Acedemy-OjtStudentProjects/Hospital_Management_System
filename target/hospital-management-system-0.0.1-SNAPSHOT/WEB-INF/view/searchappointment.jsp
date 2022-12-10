<%@page import="com.hospitalmanagement.constants.DatabaseConstants.TreatmentStatus"%>
<%@page import="com.hospitalmanagement.constants.DatabaseConstants.BillMade"%>
<%@page import="com.hospitalmanagement.constants.DatabaseConstants.WantMedicinesFromHospital"%>
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
<%@ page import ="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Appointment</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="./components/navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-4">
       <form class="form-inline ml-5" action="searchappointmentbyid">
          <div class="form-group">
            <label for="inputPassword2" class="text-color"><h4>Search Appointment By Id</h4></label>
            <input type="number" class="form-control ml-3" id="inputPassword2" name="appointmentid" placeholder="Enter Appointment Id..">
          </div>
          <button type="submit" class="btn text-color custom-bg ml-2">Search</button>
       </form>
       <form class="form-inline mt-1" action="searchappointmentbypatientname">
          <div class="form-group">
            <label for="inputPassword2" class="text-color ml-5"><h4>Search Appointment By Patient name</h4></label>
            <input type="text" class="form-control ml-3" id="inputPassword2" name="patientname" placeholder="Enter Patient name..">
          </div>
          <button type="submit" class="btn text-color custom-bg ml-2">Search</button>
       </form>
        <form class="form-inline mt-1" action="searchappointmentbydate">
          <div class="form-group">
            <label for="inputPassword2" class="text-color ml-5"><h4>Search Appointment By Date</h4></label>
            <input type="text" class="form-control ml-3" id="inputPassword2" name="appointmentdate" placeholder="Enter Date..">
          </div>
          <button type="submit" class="btn text-color custom-bg ml-2">Search</button>
       </form>
       <%
           Date date = new Date();  
           SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
           String strDate= formatter.format(date);  
       %>
       <a href="searchappointmentbydate?appointmentdate=<%=strDate%>" class="ml-2"><button class="btn text-color custom-bg ml-2">Get Todays Appointments</button></a>
  </div>
  <div class="table-responsive">
          <table class="table">
  <thead class="custom-bg text-color">
    <tr>
      <th scope="col">Appointment No.</th>
      <th scope="col">Patient Name</th> 
      <th scope="col">Patient Age</th>    
      <th scope="col">Patient Blood Group</th>
      <th scope="col">Patient Contact</th>
      <th scope="col">Appointed Doctor</th>
      <th scope="col">Appointment Taken Date</th>
      <th scope="col">Appointment Date</th>
      <th scope="col">Appointment Time</th>
      <th scope="col">Treatment Status</th>
      <th scope="col">Treatment Price</th> 
      <th scope="col">Action</th> 
    </tr>
  </thead>
  
   <%
      List<Appointment> listOfAppointments = (List<Appointment>)request.getAttribute("appointments");
      PatientResource patientResource = (PatientResource)request.getAttribute("patientResource");
      DoctorResource doctorResource = (DoctorResource)request.getAttribute("doctorResource");
 
      if(listOfAppointments != null ) {
          for(Appointment a : listOfAppointments) {
        	  Patient patient = patientResource.getPatientById(a.getPatientid());
              Doctor doctor = doctorResource.getDoctorById(a.getDoctorid());
    %>
  <tbody>
    <tr class="text-center">
      <td class="mid-align"><%=a.getId()%></td>
      <td class="mid-align"><%=patient.getFirstname() %></td>
      <td class="mid-align"><%=patient.getAge() %></td>
      <td class="mid-align"><%=patient.getBloodgroup() %></td>
      <td class="mid-align"><%=patient.getMobileno() %></td>
      <td class="mid-align"><%=doctor.getFirstname()+" " %>(<%= doctor.getSpecialist() %>)</td>
      <td class="mid-align"><%=a.getAppointmenttakendate()+" " %><%=a.getAppointmenttakentime() %></td>
      <td class="mid-align"><%=a.getAppointmentdate() %></td>
      <td class="mid-align"><%=a.getAppointmenttime() %></td>
      <td class="mid-align <%if(TreatmentStatus.DONE.value().equals(a.getTreatmentstatus())) { %>text-success <% } else if(TreatmentStatus.PENDING.value().equals(a.getTreatmentstatus())) { %> text-danger <% }%>"><%=a.getTreatmentstatus()%></td>
      <td class="mid-align"><%=a.getTreatmentprice()%></td>
      <td class="mid-align">
      
          <%
             if(TreatmentStatus.DONE.value().equals(a.getTreatmentstatus()) && a.getBillMade().equals(BillMade.NO.value())) {
          %>
          <a href="makebill?appointmentId=<%=a.getId()%>"><button type="button"
             class="btn custom-bg text-color">Make Bill</button></a>
          <%
             }
             else if(TreatmentStatus.DONE.value().equals(a.getTreatmentstatus()) && a.getBillMade().equals(BillMade.YES.value())) {
          %>
          <a href="downloadBill?appointmentId=<%=a.getId()%>"><button type="button"
             class="btn custom-bg text-color">Download Bill</button></a>
          <% 
             }
          
             else if(TreatmentStatus.PENDING.value().equals(a.getTreatmentstatus())) {
          %>
             <span class="text-danger">Treatment Pending</span>
          <%
             }
          %>
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