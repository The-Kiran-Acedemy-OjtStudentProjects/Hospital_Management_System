<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.hospitalmanagement.model.*"%>
<%@ page import="com.hospitalmanagement.dao.*"%>
<%@ page import="com.hospitalmanagement.resource.*"%>
<%@ page import="com.hospitalmanagement.service.*"%>
<%@ page import="com.hospitalmanagement.constants.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
	<%@ include file="./components/navbar.jsp"%>

	<%
	AppointmentResource appointmentResource = (AppointmentResource) request.getAttribute("appointmentResource");
	MedicineResource medicineResource = (MedicineResource) request.getAttribute("medicineResource");
	MedicineCompanyResource companyResource = (MedicineCompanyResource) request.getAttribute("companyResource");
	MedicineDistributorResource distributorResource = (MedicineDistributorResource) request
			.getAttribute("distributorResource");
	ReceptionistResource receptionistResource = (ReceptionistResource) request.getAttribute("receptionistResource");
	PatientResource patientResource = (PatientResource) request.getAttribute("patientResource");
	DoctorResource doctorResource = (DoctorResource) request.getAttribute("doctorResource");
	PharmacistResource pharmacistResource = (PharmacistResource) request.getAttribute("pharmacistResource");

	String view = (String) request.getAttribute("view");

	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	String todayDate = formatter.format(date);
	%>

	<div class="row mt-4 ml-1">

		<div class="col-sm-2">
			<div class="card card-border">
				<div class="list-group">
					<a href="admindashboard?view=<%=DatabaseConstants.AdminView.DASHBOARD.value()%>"><button type="button"
						class="list-group-item list-group-item-action <%if (view.equals(DatabaseConstants.AdminView.DASHBOARD.value())) {%> custom-bg <%}%>">
						Dashboard</button></a>
					<a href="admindashboard?view=<%=DatabaseConstants.AdminView.APPOINTMENT.value()%>"><button type="button"
						class="list-group-item list-group-item-action <%if (view.equals(DatabaseConstants.AdminView.APPOINTMENT.value())) {%> custom-bg <%}%>">
						Appointment</button></a>
					<a href="admindashboard?view=<%=DatabaseConstants.AdminView.MEDICINE.value()%>"><button type="button"
						class="list-group-item list-group-item-action <%if (view.equals(DatabaseConstants.AdminView.MEDICINE.value())) {%> custom-bg <%}%>">
						Medicine</button></a>
					<a href="admindashboard?view=<%=DatabaseConstants.AdminView.DOCTOR.value()%>"><button type="button"
						class="list-group-item list-group-item-action <%if (view.equals(DatabaseConstants.AdminView.DOCTOR.value())) {%> custom-bg <%}%>">
						Doctor</button></a>
					<a href="admindashboard?view=<%=DatabaseConstants.AdminView.RECEPTIONIST.value()%>"><button type="button"
						class="list-group-item list-group-item-action <%if (view.equals(DatabaseConstants.AdminView.RECEPTIONIST.value())) {%> custom-bg <%}%>">
						Receptionist</button></a>
					<a href="admindashboard?view=<%=DatabaseConstants.AdminView.PHARMACIST.value()%>"><button type="button"
						class="list-group-item list-group-item-action <%if (view.equals(DatabaseConstants.AdminView.PHARMACIST.value())) {%> custom-bg <%}%>">
						Pharmacist</button></a>
					<a href="admindashboard?view=<%=DatabaseConstants.AdminView.PATIENT.value()%>"><button type="button"
						class="list-group-item list-group-item-action <%if (view.equals(DatabaseConstants.AdminView.PATIENT.value())) {%> custom-bg <%}%>">
						Patient</button></a>
					<a href="admindashboard?view=<%=DatabaseConstants.AdminView.EARNING.value()%>"><button type="button"
						class="list-group-item list-group-item-action <%if (view.equals(DatabaseConstants.AdminView.EARNING.value())) {%> custom-bg <%}%>">
						Earning</button></a>
				</div>
			</div>
		</div>

		<div class="col-sm-10">
			<div class="col-sm-12">
				<%
				if (view.equals(DatabaseConstants.AdminView.DASHBOARD.value())) {
				%>

				<div class="row">
					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b class="ml-1">Total
									Appointments Today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=appointmentResource.getAppointmentCountByDate(todayDate)%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b class="ml-1">Medicines
									Added Today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=medicineResource.getMedicineCountByDateAdded(todayDate)%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b>Companies Added Today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=companyResource.getCompanyCountUsingRegisteredDate(todayDate)%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b>Distributors Added
									Today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=distributorResource.getDistributorCountUsingRegisteredDate(todayDate)%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b>Total Earnings Today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3>
									&#8377;<%=appointmentResource.getTotalEarningToday()%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b class="ml-1">Total
									Appointments</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=appointmentResource.getTotalAppointmentsCount()%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b class="ml-1">Total
									Medicines</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=medicineResource.getMedicinesTotalCount()%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b class="ml-4">Total
									Doctors</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=doctorResource.getDoctorsTotalCount()%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"><b class="ml-4">Total
									Patients</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=patientResource.getPatientsTotalCount()%></h3>
							</div>
						</div>

					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b>Total Pharmacists</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=pharmacistResource.getPharmacistTotalCount()%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b>Total Receptionist</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=receptionistResource.getReceptionistTotalCount()%></h3>
							</div>
						</div>

					</div>

					<div class="col-sm-2">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b>Total Treatments Today
								</b>
							</div>
							<div class="card-body text-color text-center">
								<h3>
									&#8377;<%=appointmentResource.getSumOfPriceFromAppointmentByBillingDate(todayDate)%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-6">

						<div class="card card-border" style="height: 30rem;">
							<div class="card-header text-color text-center">Todays Appointments</div>
							<div class="card-body text-color text-center">
								<table class="table table-responsive table-hover">
									<thead class="custom-bg">
										<tr>
											<th scope="col">Appointment Id</th>
											<th scope="col">Pateint Name</th>
											<th scope="col">Doctor Name</th>
											<th scope="col">Apointment Date</th>
											<th scope="col">Treatment Price</th>
											<th scope="col">Took Medicine</th>
											<th scope="col">Treatment Status</th>
										</tr>
									</thead>
									<%
									    List<Appointment> aps = appointmentResource.getTop5AppointmentsByDate(todayDate);
									    for(Appointment a : aps){
									%>
									
									<tbody>
										<tr>
											<th scope="row"><%=a.getId() %></th>
											<td><%=patientResource.getPatientById(a.getPatientid()).getFirstname()%></td>
											<td><%=doctorResource.getDoctorById(a.getDoctorid()).getFirstname()%></td>
											<td><%=a.getAppointmentdate() %></td>
											<td><%=a.getTreatmentprice() %></td>
											<td><% if(a.getWantMedicine() == null ){%>No<% } else{%><%=a.getWantMedicine() %> <%} %></td>
											<td><%=a.getTreatmentstatus() %></td>
										</tr>

									</tbody>
									<%
									    }
									%>
								</table>
							</div>
							<div class="text-right text-color"><small>and more..</small></div>
						</div>

					</div>

					<div class="col-sm-6">

						<div class="card card-border" style="height: 30rem;">
							<div class="card-header text-color text-center">Patients Registered today</div>
							<div class="card-body text-color text-center">
								<table class="table table-responsive table-hover">
									<thead class="custom-bg">
										<tr>
										    <th scope="col">Patient Id</th>
											<th scope="col">First Name</th>
											<th scope="col">Last Name</th>
											<th scope="col">Age</th>
											<th scope="col">Blood Grp</th>
											<th scope="col">City</th>
											<th scope="col">Email Id</th>
										</tr>
									</thead>
									<%
									    List<Patient> pats = patientResource.getTop5PatientBydate(todayDate);
									    for(Patient p : pats){
									%>
									<tbody>
										<tr>
											<th scope="row"><%=p.getId() %></th>
											<td><%=p.getFirstname() %></td>
											<td><%=p.getLastname() %></td>
											<td><%=p.getAge() %></td>
											<td><%=p.getBloodgroup() %></td>
											<td><%=p.getCity() %></td>
											<td><%=p.getEmailid() %></td>
										</tr>
									</tbody>
									<%
									    }
									%>
								</table>
							</div>
							<div class="text-right text-color"><small>and more..</small></div>
						</div>

					</div>

					<div class="col-sm-4">

						<div class="card card-border" style="height: 20rem;">
							<div class="card-header text-color text-center">
								<b class="ml-1">Medicines Added Today</b>
							</div>
							<div class="card-body text-color text-center">
								<table class="table table-responsive table-hover">
									<thead class="custom-bg">
										<tr>
											<th scope="col">Medicine Name</th>
											<th scope="col">Type</th>
											<th scope="col">Company</th>
											<th scope="col">Distributor</th>
											<th scope="col">Price</th>
										</tr>
									</thead>
									<%
									    List<Medicine> meds = medicineResource.getTop5MedicinesByDate(todayDate);
									    for(Medicine m : meds){
									%>
									<tbody>
										<tr>
											<td><%=m.getName() %></td>
											<td><%=m.getType() %></td>
											<td><%=companyResource.getCompanyById(m.getCompanyid()).getName() %></td>
											<td><%=distributorResource.getDistributorById(m.getDistributorid()).getName() %></td>
											<td><%=m.getPrice() %></td>
										</tr>
									</tbody>
									<%
									    }
									%>
								</table>
							</div>
							<div class="text-right text-color"><small>and more..</small></div>
						</div>

					</div>

					<div class="col-sm-4">

						<div class="card card-border" style="height: 20rem;">
							<div class="card-header text-color text-center">
								<b class="ml-1">Company Added Today</b>
							</div>
							<div class="card-body text-color text-center">
								<table class="table table-responsive table-hover">
									<thead class="custom-bg">
										<tr>
											<th scope="col">Company Name</th>
											<th scope="col">Email Id</th>
											<th scope="col">Phone No</th>
											<th scope="col">City</th>
										</tr>
									</thead>
									
									<%
									    List<MedicineCompany> comps = companyResource.getTop5CompanysByDateAdded(todayDate);
									    for(MedicineCompany m : comps){
									%>
									
									<tbody>
										<tr>
											<th scope="row"><%=m.getName() %></th>
											<td><%=m.getEmailid() %></td>
											<td><%=m.getMobileno() %></td>
											<td><%=m.getCity() %></td>
										</tr>
									</tbody>
									<%
									    }
									%>
								</table>
							</div>
							<div class="text-right text-color"><small>and more..</small></div>
						</div>

					</div>

					<div class="col-sm-4">

						<div class="card card-border" style="height: 20rem;">
							<div class="card-header text-color text-center">
								<b class="ml-1">Distributor Added Today</b>
							</div>
							<div class="card-body text-color text-center">
								<table class="table table-responsive table-hover">
									<thead class="custom-bg">
										<tr>
											<th scope="col">Distributor Name</th>
											<th scope="col">Email Id</th>
											<th scope="col">Phone No</th>
											<th scope="col">City</th>
										</tr>
									</thead>
									<%
									    List<MedicineDistributor> dis = distributorResource.getTop5DistributorAddedByDate(todayDate);
									    for(MedicineDistributor m : dis){
									%>
									
									<tbody>
										<tr>
											<th scope="row"><%=m.getName() %></th>
											<td><%=m.getEmailid() %></td>
											<td><%=m.getMobileno() %></td>
											<td><%=m.getCity() %></td>
										</tr>
									</tbody>
									<%
									    }
									%>
								</table>
							</div>
						</div>

					</div>
				</div>
				<%
				}

				else if (view.equals(DatabaseConstants.AdminView.APPOINTMENT.value())) {//
				%>
				<div class="row">
					<div class="col-sm-3">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b class="ml-1">Total
									Appointments Today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=appointmentResource.getAppointmentCountByDate(todayDate)%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b>Total Appointments</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=appointmentResource.getTotalAppointmentsCount()%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b>Appointment Taken today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3>
									<%=appointmentResource.getAppointmentCountByAppointmentTakenDate(todayDate)%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b class="ml-1">Treatment Done Today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=appointmentResource.getAppointmentCountByTreatmentStatusAndBillingDate(DatabaseConstants.TreatmentStatus.DONE.value(), todayDate)%></h3>
							</div>
						</div>
					</div>
					
					<div class="text-center">
					   <h3 class="text-color">Search Appointments</h3>
					</div>

					<div class="mt-1">
					  <div class="row">
						<form class="form-inline" action="searchappointmentbyId">
							<div class="form-group">
								<input type="number"
									class="form-control ml-3" id="inputPassword2"
									name="appointmentid" placeholder="Enter Appointment Id..">
							</div>
							<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
						</form>
						<form class="form-inline mt-1"
							action="searchappointmentbypatientName">
							<div class="form-group">
							  <input type="text"
									class="form-control ml-3" id="inputPassword2"
									name="patientname" placeholder="Enter Patient name..">
							</div>
							<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
						</form>
						<form class="form-inline mt-1" action="searchappointmentbyDate">
							<div class="form-group">
							  <input type="text"
									class="form-control ml-3" id="inputPassword2"
									name="appointmentdate" placeholder="Enter Date..">
							</div>
							<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
						</form>
						<%
						Date dat = new Date();  
		                   SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");  
						String strDat = format.format(dat);
						%>
						<a href="searchappointmentbyDate?appointmentdate=<%=strDat%>"
							class="ml-1"><button class="btn text-color custom-bg ml-2">Get
								Todays Appointments</button></a>
								</div>
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
							
								</tr>
							</thead>

							<%
							List<Appointment> listOfAppointments = (List<Appointment>) request.getAttribute("appointments");

							if (listOfAppointments != null) {
								for (Appointment a : listOfAppointments) {
									Patient patient = patientResource.getPatientById(a.getPatientid());
									Doctor doctor = doctorResource.getDoctorById(a.getDoctorid());
							%>
							<tbody>
								<tr class="text-center">
									<td class="mid-align"><%=a.getId()%></td>
									<td class="mid-align"><%=patient.getFirstname()%></td>
									<td class="mid-align"><%=patient.getAge()%></td>
									<td class="mid-align"><%=patient.getBloodgroup()%></td>
									<td class="mid-align"><%=patient.getMobileno()%></td>
									<td class="mid-align"><%=doctor.getFirstname() + " "%>(<%=doctor.getSpecialist()%>)</td>
									<td class="mid-align"><%=a.getAppointmenttakendate() + " "%><%=a.getAppointmenttakentime()%></td>
									<td class="mid-align"><%=a.getAppointmentdate()%></td>
									<td class="mid-align"><%=a.getAppointmenttime()%></td>
									<td
										class="mid-align <%if (DatabaseConstants.TreatmentStatus.DONE.value().equals(a.getTreatmentstatus())) {%>text-success <%} else if (DatabaseConstants.TreatmentStatus.PENDING.value().equals(a.getTreatmentstatus())) {%> text-danger <%}%>"><%=a.getTreatmentstatus()%></td>
									<td class="mid-align"><%=a.getTreatmentprice()%></td>
								
								</tr>
							</tbody>
							<%
							}
							}
							%>
						</table>
					</div>

				</div>
				<%
				}
				
				else if (view.equals(DatabaseConstants.AdminView.MEDICINE.value())) {
				%>
				<div class="row">
					<div class="col-sm-3">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b class="ml-1">Total
									Medicines Today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=medicineResource.getMedicineCountByDateAdded(todayDate)%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b>Total Medicines</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=medicineResource.getMedicinesTotalCount()%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b>Company Added today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3>
									<%=companyResource.getCompanyCountUsingRegisteredDate(todayDate)%></h3>
							</div>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="card card-border">
							<div class="card-header text-color text-center">
								<img src="resources/images/logo.png"
									class="rounded mx-auto pt-2 d-inline-block" alt="img"
									height="40px" width="40px"> <b class="ml-1">Distributor Added today</b>
							</div>
							<div class="card-body text-color text-center">
								<h3><%=distributorResource.getDistributorCountUsingRegisteredDate(todayDate)%></h3>
							</div>
						</div>
					</div>
					
					<div class="text-center">
					   <h3 class="text-color">Search Medicines</h3>
					</div>

					<div class="mt-1">
					  <div class="row">
						<form class="form-inline" action="searchmedicinebyId">
							<div class="form-group">
								<input type="number"
									class="form-control ml-3" id="inputPassword2"
									name="medicineId" placeholder="Enter Medicine Id..">
							</div>
							<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
						</form>
						<form class="form-inline mt-1" action="searchmedicinebyName">
							<div class="form-group">
							  <input type="text"
									class="form-control ml-3" id="inputPassword2"
									name="medicineName" placeholder="Enter Medicine name..">
							</div>
							<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
						</form>
								</div>
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
								</tr>
							</thead>

							<%
      List<Medicine> listOfMedicines = (List<Medicine>)request.getAttribute("medicines");
      MedicineResource mResource = (MedicineResource)request.getAttribute("medicineResource");
      MedicineCompanyResource medicineCompanyResource = (MedicineCompanyResource)request.getAttribute("companyResource");
      MedicineDistributorResource medicineDistributorResource = (MedicineDistributorResource)request.getAttribute("distributorResource");

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
            </tr>
          </tbody>
    <%
          }
      }
    %>
						</table>
					</div>

				</div>
				<%
				}
				else if (view.equals(DatabaseConstants.AdminView.DOCTOR.value())) {
					%>
					<div class="row">
						<div class="col-sm-6">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b class="ml-1">Total
										Doctors Today</b>
								</div>
								<div class="card-body text-color text-center">
									<h3><%=doctorResource.getDoctorCountByRegisteredDate(todayDate)%></h3>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b>Total Doctors</b>
								</div>
								<div class="card-body text-color text-center">
									<h3><%=doctorResource.getDoctorsTotalCount()%></h3>
								</div>
							</div>
						</div>
						
						<div class="text-center">
						   <h3 class="text-color">Search Doctors</h3>
						</div>

						<div class="mt-1">
						  <div class="row">
							<form class="form-inline" action="searchdoctorbyId">
								<div class="form-group">
									<input type="number"
										class="form-control ml-3" id="inputPassword2"
										name="doctorId" placeholder="Enter doctor Id..">
								</div>
								<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
							</form>
							<form class="form-inline mt-1" action="searchdoctorbyName">
								<div class="form-group">
								  <input type="text"
										class="form-control ml-3" id="inputPassword2"
										name="doctorName" placeholder="Enter Doctor name..">
								</div>
								<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
							</form>
									</div>
						</div>

						<div class="table-responsive">
							<table class="table">
								<thead class="custom-bg text-color">
									<tr>
										<th scope="col">Doctor Id</th>
	                                    <th scope="col">Doctor Name</th> 
	                                    <th scope="col">Specialist</th>    
	                                    <th scope="col">Age</th>
	                                    <th scope="col">Phone No,</th>
	                                    <th scope="col">Email Id</th>
	                                    <th scope="col">Username</th>
	                                    <th scope="col">City</th>
									</tr>
								</thead>

								<%
	      List<Doctor> listOfDoctors = (List<Doctor>)request.getAttribute("doctors");

	      if(listOfDoctors != null) {
	          for(Doctor d : listOfDoctors) {
	     
	            %> 
	          <tbody>
	            <tr class="text-center">
	              <td class="mid-align"><%=d.getId()%></td>
	              <td class="mid-align"><%=d.getFirstname() %></td>
	              <td class="mid-align"><%=d.getSpecialist()%></td>
	              <td class="mid-align"><%=d.getAge() %></td>
	              <td class="mid-align"><%=d.getMobileno()%></td>
	              <td class="mid-align"><%=d.getEmailid() %></td>
	              <td class="mid-align"><%=d.getUsername() %></td>
	              <td class="mid-align"><%=d.getCity() %></td>
	            </tr>
	          </tbody>
	    <%
	          }
	      }
	    %>
							</table>
						</div>

					</div>
					<%
					}
				else if (view.equals(DatabaseConstants.AdminView.RECEPTIONIST.value())) {
					%>
					<div class="row">
						<div class="col-sm-6">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b class="ml-1">Total
										Receptionist Today</b>
								</div>
								<div class="card-body text-color text-center">
									<h3><%=receptionistResource.getReceptionistCountByRegisterDate(todayDate)%></h3>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b>Total Receptionist</b>
								</div>
								<div class="card-body text-color text-center">
									<h3><%=receptionistResource.getReceptionistTotalCount()%></h3>
								</div>
							</div>
						</div>
						
						<div class="text-center">
						   <h3 class="text-color">Search Receptionist</h3>
						</div>

						<div class="mt-1">
						  <div class="row">
							<form class="form-inline" action="searchreceptionistbyId">
								<div class="form-group">
									<input type="number"
										class="form-control ml-3" id="inputPassword2"
										name="receptionistId" placeholder="Enter receptionist Id..">
								</div>
								<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
							</form>
							<form class="form-inline mt-1" action="searchreceptionistbyName">
								<div class="form-group">
								  <input type="text"
										class="form-control ml-3" id="inputPassword2"
										name="receptionistName" placeholder="Enter receptionist name..">
								</div>
								<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
							</form>
									</div>
						</div>

						<div class="table-responsive">
							<table class="table">
								<thead class="custom-bg text-color">
									<tr>
										<th scope="col">Receptionist Id</th>
	                                    <th scope="col">Receptionist Name</th> 
	                                    <th scope="col">Email Id</th>    
	                                    <th scope="col">Phone No</th>
	                                    <th scope="col">Age</th>
	                                    <th scope="col">Username</th>
	                                    <th scope="col">City</th>
									</tr>
								</thead>

								<%
	      List<Receptionist> listOfReceptionists = (List<Receptionist>)request.getAttribute("receptionists");

	      if(listOfReceptionists != null) {
	          for(Receptionist r : listOfReceptionists) {
	     
	            %> 
	          <tbody>
	            <tr class="text-center">
	              <td class="mid-align"><%=r.getId()%></td>
	              <td class="mid-align"><%=r.getFirstname() %></td>
	              <td class="mid-align"><%=r.getEmailid()%></td>
	              <td class="mid-align"><%=r.getMobileno()%></td>
	              <td class="mid-align"><%=r.getAge()%></td>
	              <td class="mid-align"><%=r.getUsername() %></td>
	              <td class="mid-align"><%=r.getCity() %></td>
	            </tr>
	          </tbody>
	    <%
	          }
	      }
	    %>
							</table>
						</div>

					</div>
					<%
					}
					else if (view.equals(DatabaseConstants.AdminView.PHARMACIST.value())) {
					%>
					<div class="row">
						<div class="col-sm-6">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b class="ml-1">Total
										Pharmacists Today</b>
								</div>
								<div class="card-body text-color text-center">
									<h3><%=pharmacistResource.getPharmacistCountByRegisteredDate(todayDate)%></h3>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b>Total Pharmacists</b>
								</div>
								<div class="card-body text-color text-center">
									<h3><%=pharmacistResource.getPharmacistTotalCount()%></h3>
								</div>
							</div>
						</div>
						
						<div class="text-center">
						   <h3 class="text-color">Search Pharamacist</h3>
						</div>

						<div class="mt-1">
						  <div class="row">
							<form class="form-inline" action="searchpharmacistbyId">
								<div class="form-group">
									<input type="number"
										class="form-control ml-3" id="inputPassword2"
										name="pharmacistId" placeholder="Enter pharmacist Id..">
								</div>
								<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
							</form>
							<form class="form-inline mt-1" action="searchpharmacistbyName">
								<div class="form-group">
								  <input type="text"
										class="form-control ml-3" id="inputPassword2"
										name="pharmacistName" placeholder="Enter pharmacist name..">
								</div>
								<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
							</form>
									</div>
						</div>

						<div class="table-responsive">
							<table class="table">
								<thead class="custom-bg text-color">
									<tr>
										<th scope="col">Pharmacist Id</th>
	                                    <th scope="col">Pharmacist Name</th> 
	                                    <th scope="col">Email Id</th>    
	                                    <th scope="col">Phone No</th>
	                                    <th scope="col">Age</th>
	                                    <th scope="col">Username</th>
	                                    <th scope="col">City</th>
									</tr>
								</thead>

								<%
	      List<Pharmacist> listOfPharmacists = (List<Pharmacist>)request.getAttribute("pharmacists");

	      if(listOfPharmacists != null) {
	          for(Pharmacist r : listOfPharmacists) {
	     
	            %> 
	          <tbody>
	            <tr class="text-center">
	              <td class="mid-align"><%=r.getId()%></td>
	              <td class="mid-align"><%=r.getFirstname() %></td>
	              <td class="mid-align"><%=r.getEmailid()%></td>
	              <td class="mid-align"><%=r.getMobileno()%></td>
	              <td class="mid-align"><%=r.getAge()%></td>
	              <td class="mid-align"><%=r.getUsername() %></td>
	              <td class="mid-align"><%=r.getCity() %></td>
	            </tr>
	          </tbody>
	    <%
	          }
	      }
	    %>
							</table>
						</div>

					</div>
					<%
					}
					else if (view.equals(DatabaseConstants.AdminView.PATIENT.value())) {
					%>
					<div class="row">
						<div class="col-sm-6">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b class="ml-1">Total
										Patients Today</b>
								</div>
								<div class="card-body text-color text-center">
									<h3><%=patientResource.getPatientsByRegisteredDate(todayDate)%></h3>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b>Total Patients</b>
								</div>
								<div class="card-body text-color text-center">
									<h3><%=patientResource.getPatientsTotalCount()%></h3>
								</div>
							</div>
						</div>

						
						
						<div class="text-center">
						   <h3 class="text-color">Search Patient</h3>
						</div>

						<div class="mt-1">
						  <div class="row">
							<form class="form-inline" action="searchpatientbyId">
								<div class="form-group">
									<input type="number"
										class="form-control ml-3" id="inputPassword2"
										name="patientId" placeholder="Enter patient Id..">
								</div>
								<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
							</form>
							<form class="form-inline mt-1" action="searchpatientbyName">
								<div class="form-group">
								  <input type="text"
										class="form-control ml-3" id="inputPassword2"
										name="patientName" placeholder="Enter patient name..">
								</div>
								<button type="submit" class="btn text-color custom-bg ml-2">Search</button>
							</form>
									</div>
						</div>

						<div class="table-responsive">
							<table class="table">
								<thead class="custom-bg text-color">
									<tr>
										<th scope="col">Patient Id</th>
	                                    <th scope="col">Patient Name</th> 
	                                    <th scope="col">Email Id</th>    
	                                    <th scope="col">Phone No</th>
	                                    <th scope="col">Age</th>
	                                    <th scope="col">Blood group</th>
	                                    <th scope="col">City</th>
									</tr>
								</thead>

								<%
	      List<Patient> listOfPatients = (List<Patient>)request.getAttribute("patients");

	      if(listOfPatients != null) {
	          for(Patient r : listOfPatients) {
	     
	            %> 
	          <tbody>
	            <tr class="text-center">
	              <td class="mid-align"><%=r.getId()%></td>
	              <td class="mid-align"><%=r.getFirstname() %></td>
	              <td class="mid-align"><%=r.getEmailid()%></td>
	              <td class="mid-align"><%=r.getMobileno()%></td>
	              <td class="mid-align"><%=r.getAge()%></td>
	              <td class="mid-align"><%=r.getBloodgroup() %></td>
	              <td class="mid-align"><%=r.getCity() %></td>
	            </tr>
	          </tbody>
	    <%
	          }
	      }
	    %>
							</table>
						</div>

					</div>
					<%
					}
					else if (view.equals(DatabaseConstants.AdminView.EARNING.value())) {
					%>
					<div class="row">
						<div class="col-sm-3">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b class="ml-1">Total
										Earnings Today</b>
								</div>
								<div class="card-body text-color text-center">
									<h3><%=appointmentResource.getTotalEarningToday()%></h3>
								</div>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b>Todays medicine earning</b>
								</div>
								<div class="card-body text-color text-center">
									<h3><%=medicineResource.getMedicinesTodayEarning()%></h3>
								</div>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b>Todays treatment earning</b>
								</div>
								<div class="card-body text-color text-center">
									<h3>
										 <%=appointmentResource.getTotalTodaysAppointmentTreatmentPrice()%></h3>
								</div>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="card card-border">
								<div class="card-header text-color text-center">
									<img src="resources/images/logo.png"
										class="rounded mx-auto pt-2 d-inline-block" alt="img"
										height="40px" width="40px"> <b class="ml-1">Total Treatments Earning</b>
								</div>
								<div class="card-body text-color text-center">
									 <h3><%=appointmentResource.getTotalAppointmentTreatmentPrice()%></h3>
								</div>
							</div>
						</div>
						</div>
						<%
				         	}    
						%>
					
					
			</div>
		</div>
	</div>

</body>
</html>