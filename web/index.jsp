<% String user = request.getParameter("result")!=null ? "success" : "false"; %>
<%
    if(user.equals("success")){
        %>
        <center><b>Registration Successfull! Please Login to Continue</b></center>
        <%
    } 
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <link rel="stylesheet" href="css/index.css" />
    <link rel="stylesheet" href="css/bg.css" />
  </head>
  <body>
    <div class="login-page">
      <div class="form">
        <h2 style="color: green">2 Chaha</h2>
        <form class="register-form" action="signup" method="post">
            <select name="usertype">
                <option value="user">User</option>
                <option value="boy">Delivery Man</option>
            </select>
          <input type="text" placeholder="Name" name="name"/>
          <input type="password" placeholder="Password" name="password"/>
          <input type="text" placeholder="Email Address" name="email"/>
          <input type="text" placeholder="Mobile Number" name="mobile"/>
          <textarea placeholder="Address" name="address"></textarea>
          <button type="submit">create</button>
          <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form class="login-form" action="login" method="post">
          <input type="text" placeholder="Username" name="email"/>
          <input type="password" placeholder="Password" name="password"/>
          <button type="submit">login</button>
          <p class="message">
            Not registered? <a href="#">Create an account</a>
          </p>
        </form>
      </div>
    </div>
    <img
      src="https://img.freepik.com/free-photo/flat-lay-tea-cup-yellow-background_23-2148174209.jpg?size=626&ext=jpg"
      id="bg"
      alt="Image"
    />

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/index.js"></script>
  </body>
</html>
