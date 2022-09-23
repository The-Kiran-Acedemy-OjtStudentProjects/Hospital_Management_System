<nav class="navbar navbar-expand-lg navbar-light custom-bg">
  <a class="navbar-brand" href="/hospital-management-system/home">
    <img src="resources/images/logo.png" width="35" height="35" class="d-inline-block align-top" alt="">
   <i><b><span class="text-color">Hospital Management System</span></b></i>
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <% String userlogin =(String) session.getAttribute("user-login"); %>
  
  <%
     if(userlogin == null) {
  %>
 
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active   ml-5" data-toggle="modal" data-target=".aboutusmodal">
        <a class="nav-link"><b><span class="text-color">About us</span></b><span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active  ml-5" data-toggle="modal" data-target=".contactusmodal">
        <a class="nav-link text-color"><b><span class="text-color">Developers Contact</span></b></a>
      </li>
       <li class="nav-item active  ml-5">
        <a class="nav-link text-color" href="login"><b><span class="text-color">Login</span></b></a>
      </li>
    </ul>
   </div>
   
  <%
     }
  
     else if(userlogin != null) {
  %>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
       
       <%
          if(userlogin.equals("admin")) {
       %>
           <li class="nav-item active  ml-5">
            <a class="nav-link" href="admindashboard?view=admindashboard"><b><span class="text-color">Admin Dashboard</span></b><span class="sr-only">(current)</span></a>
           </li>
       <%
          }
       %>
       
       <%
          if(userlogin.equals("doctor")) {
       %>
           <li class="nav-item active  ml-5">
            <a class="nav-link" href="mypatient"><b><span class="text-color">View My Patients</span></b><span class="sr-only">(current)</span></a>
           </li>
       <%
          }
       %>
       
       <%
          if(userlogin.equals("receptionist")) {
       %>
           <li class="nav-item active  ml-5">
            <a class="nav-link" href="searchappointment"><b><span class="text-color">Make Bill</span></b><span class="sr-only">(current)</span></a>
           </li>
           
           <li class="nav-item active  ml-5">
            <a class="nav-link" href="appointment"><b><span class="text-color">Add Appointment</span></b><span class="sr-only">(current)</span></a>
           </li>
       <%
          }
       %>
       
       <%
          if(userlogin.equals("pharmacist")) {
       %>
           <li class="nav-item active  ml-5">
            <a class="nav-link" href="addmedicine"><b><span class="text-color">Add Medicine</span></b><span class="sr-only">(current)</span></a>
           </li>
           
           <li class="nav-item active  ml-5">
            <a class="nav-link" href="addmedicinecompany"><b><span class="text-color">Add Company</span></b><span class="sr-only">(current)</span></a>
           </li>
           
           <li class="nav-item active  ml-5">
            <a class="nav-link" href="addmedicinedistributor"><b><span class="text-color">Add Distributor</span></b><span class="sr-only">(current)</span></a>
           </li>
       <%
          }
       %>
       
    
      <li class="nav-item active  ml-5" data-toggle="modal" data-target=".aboutusmodal">
        <a class="nav-link"><b><span class="text-color">About us</span></b><span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active  ml-5" data-toggle="modal" data-target=".contactusmodal">
        <a class="nav-link text-color"><b><span class="text-color">Developers Contact</span></b></a>
      </li>
    </ul>
   </div>
   
   <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
     <%
          if(userlogin.equals("admin")) {
       %>
      <li class="nav-item active  ml-5">
        <a class="nav-link" href="register"><b><span class="text-color">Register Users</span></b><span class="sr-only">(current)</span></a>
      </li>
      <%
          }
      %>
      <%
          if(userlogin.equals("receptionist")) {
       %>
      <li class="nav-item active  ml-5">
        <a class="nav-link" href="patientregister"><b><span class="text-color">Register Patients</span></b><span class="sr-only">(current)</span></a>
      </li>
      <%
          }
      %>
      
      <%
          if(userlogin.equals("pharmacist")) {
       %>
      <li class="nav-item active  ml-5">
        <a class="nav-link" href="searchmedicine"><b><span class="text-color">Search Medicine</span></b><span class="sr-only">(current)</span></a>
      </li>
      <%
          }
      %>
       <li class="nav-item active  ml-5">
         <a class="nav-link" href="logout"><b><span class="text-color">Logout</span></b><span class="sr-only">(current)</span></a>
       </li>    
      
    </ul>
  </div>
  <%
     }
  %>

  
</nav>

<!-- About us modal -->

<div class="modal fade aboutusmodal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
       <div class="modal-header custom-bg text-white text-center">
        <h5 class="modal-title" id="exampleModalLongTitle" >About Us</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div> 
      <div class="modal-body">
        <div class="container">
        <p style="font-size:20px;">
          <b>
              HMS was introduced to solve the complications coming from managing all the paper works
               of every patient associated with the various departments of hospitalization with confidentiality.
                HMS provides the ability to manage all the paperwork in one place, reducing the work of staff in arranging
                 and analyzing the paperwork of the patients.
          </b>
        </p>
        </div>
      </div>
      <div class="modal-footer">
       <div class="text-center">
        <button type="button" class="btn custom-bg text-white" data-dismiss="modal">Close</button>
       </div>
      </div>
    </div>
  </div>
</div>
<!-- ********** -->

<!-- Contact us modal -->

<div class="modal fade contactusmodal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
       <div class="modal-header custom-bg text-white text-center">
        <h5 class="modal-title" id="exampleModalLongTitle" >Contact Us</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div> 
      <div class="modal-body">
        <div class="container text-center">
        <p style="font-size:23px;">
            <b>
                <img src="resources/images/phonee.png" style="width:27px;" alt="img">+91 9999999999 / +91 7777777777<br>
                <img src="resources/images/emaill.png" style="width:29px;" alt="img">ojthelpdesk@javabykiran.com
            </b>
        </p>
        </div>
      </div>
      <div class="modal-footer">
       <div class="text-center">
        <button type="button" class="btn custom-bg text-white" data-dismiss="modal">Close</button>
       </div>
      </div>
    </div>
  </div>
</div>
<!-- ********** -->