$.ajax({
  type: "get",
  url: "/boyhistory",
  success: function (data) {
    var orders = data;
  },
});

var orders = [
  {
    snack: "Tea",
    shop: "2 chaha Official",
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

for (var i = 0; i < orders.length; i++) {
  var appendme =
    "<tr><td>" +
    orders[i].snack +
    "</td><td>" +
    orders[i].shop +
    "</td><td>" +
    orders[i].quantity +
    "</td><td>" +
    orders[i].name +
    "</td><td>" +
    orders[i].mobile +
    "</td><td>" +
    orders[i].addr +
    "</td></tr>";
  $("#tablebody").append(appendme);
}
