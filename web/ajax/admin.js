$.ajax({
  type: "get",
  url: "http://localhost:8080/Donchaha/admin",
  datatype: 'JSON',
  success: function (data) {
    var orders = data;
    for (var i = 0; i < orders.length; i++) {
        var appendme =
          "<tr><td>" +
          orders[i][0] +
          "</td><td>" +
          orders[i][1] +
          "</td><td>" +
          orders[i][2] +
          "</td><td>" +
          orders[i][3] +
          "</td><td>" +
          orders[i][4] +
          "</td></tr>";
        $("#tablebody").append(appendme);
     }
  },
});

var orders = [
  {
    snack: "Tea",
    quantity: "2",
    name: "Dhanesh Pawar",
    mobile: "90289619149",
    addr: "Classroom 302",
  },
  {
    snack: "Pohe",
    shop: "Umiya Pohe",
    quantity: "2",
    name: "Dhanesh Pawar",
    mobile: "90289619149",
    addr: "Classroom 303",
  },
  {
    snack: "Cold Coffee",
    shop: "Cafe Creme",
    quantity: "2",
    name: "Dhanesh Pawar",
    mobile: "90289619149",
    addr: "Classroom 304",
  },
];
