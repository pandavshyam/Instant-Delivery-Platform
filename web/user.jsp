<%
    Cookie cookie = null;
    Cookie[] cookies = null;

    // Get an array of Cookies associated with the this domain
    cookies = request.getCookies();

    if( cookies != null ) {
       for (int i = 0; i < cookies.length; i++) {
          cookie = cookies[i];
          if (cookie.getName().equals("em") && cookie.getValue().equals("")){
              response.setStatus(response.SC_MOVED_TEMPORARILY);
              response.setHeader("Location", "index.jsp");
          }
       }
    }
%>
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
        <a href="user.html">Home</a>
        <a href="userprofile.html">Profile</a>
        <a href="userhistory.jsp">Order History</a>
        <a href="logout">Logout</a>
      </div>
    </div>
    <div class="container">
      <h1>Place your order</h1>
      <i>To change address <a href="/userprofile.html">click here</a>. </i>

      <hr />
      <div class="row">
        <table class="table row-select">
          <thead>
            <tr class="head">
              <th>
                <div class="checkbox table-checkbox">
                  <label class="block-label selection-button-checkbox">
                    <input
                      type="checkbox"
                      name="all"
                      value="all"
                      id="toggleAll"
                      tabindex="0"
                    />
                    ALL
                  </label>
                </div>
              </th>
              <th scope="col">Snack</th>
              <th scope="col">Price in (RS)</th>
              <th scope="col">Shop Name</th>
              <th scope="col">Status</th>
              <th scope="col">Quantity</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <div class="checkbox table-checkbox">
                  <label class="block-label selection-button-checkbox"> </label>
                  <input type="checkbox" name="ck1" value="ck1" id="ck1" />
                </div>
              </td>
              <td>Tea</td>
              <td>10</td>
              <td>2 chaha Official</td>
              <td class="text-success">Available</td>
              <td>
                <select name="sel1" id="sel1" class="form-control">
                  <option value="one">one</option>
                  <option value="two">two</option>
                  <option value="three">three</option>
                  <option value="four">four</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>
                <div class="checkbox table-checkbox">
                  <label
                    class="block-label selection-button-checkbox row-select"
                  >
                  </label>
                  <input type="checkbox" name="ck2" value="ck2" id="ck2"/>
                </div>
              </td>
              <td>Pohe</td>
              <td>15</td>

              <td>Umiya Pohe</td>
              <td class="text-warning">Not Available</td>
              <td>
                <select name="sel2" id="sel2" class="form-control">
                  <option value="one">one</option>
                  <option value="two">two</option>
                  <option value="three">three</option>
                  <option value="four">four</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>
                <div class="checkbox table-checkbox">
                  <label
                    class="block-label selection-button-checkbox row-select"
                  >
                  </label>
                  <input type="checkbox" name="ck3" value="ck3" id="ck3"/>
                </div>
              </td>
              <td>Samosa</td>
              <td>12</td>

              <td>College Canteen</td>
              <td class="text-success">Available</td>
              <td>
                <select name="sel3" id="sel3" class="form-control">
                  <option value="one">one</option>
                  <option value="two">two</option>
                  <option value="three">three</option>
                  <option value="four">four</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>
                <div class="checkbox table-checkbox">
                  <label
                    class="block-label selection-button-checkbox row-select"
                  >
                  </label>
                  <input type="checkbox" name="ck4" value="ck4" id="ck4"/>
                </div>
              </td>
              <td>Cold Coffee</td>
              <td>25</td>

              <td>CAFE CREME</td>
              <td class="text-success">Available</td>
              <td>
                <select name="sel4" id="sel4" class="form-control">
                  <option value="one">one</option>
                  <option value="two">two</option>
                  <option value="three">three</option>
                  <option value="four">four</option>
                </select>
              </td>
            </tr>
          </tbody>
        </table>
        <button
          onclick="placeorder()"
          type="submit"
          class="btn btn-green row-select-submit"
        >
          Place Order
        </button>
      </div>
      <hr />
    </div>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/user.js"></script>
    <script src="ajax/user.js"></script>
  </body>
</html>
