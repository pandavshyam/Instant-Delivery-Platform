<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User Page</title>
    <link rel="stylesheet" href="css/user.css" />
    <link rel="stylesheet" href="css/bg.css" />
  </head>
  <body>
    <div class="nav">
      <input type="checkbox" id="nav-check" />
      <div class="nav-header">
        <div class="nav-title">2 Chaha</div>
      </div>
      <div class="nav-btn">
        <label for="nav-check">
          <span></span>
          <span></span>
          <span></span>
        </label>
      </div>

      <div class="nav-links">
        <a href="user.jsp">Home</a>
        <a href="userprofile.html">Profile</a>
        <a href="userhistory.jsp">Order History</a>
        <a href="logout">Logout</a>
      </div>
    </div>
    <div class="container">
      <h1>Your order History</h1>
      <hr />
      <div class="row">
        <table class="table row-select">
          <thead>
            <tr class="head">
              <th scope="col">Date</th>
              <th scope="col">Address</th>
              <th scope="col">Snack</th>
              <th scope="col">Quantity</th>
            </tr>
          </thead>
          <tbody id="tablebody"></tbody>
        </table>
      </div>
    </div>
    <script src="js/jquery-3.2.1.min.js"></script>
    <!--<script src="js/user.js"></script>-->
    <script src="ajax/userhistory.js"></script>
  </body>
</html>
