$.ajax({
  type: "get",
  url: "/userhistory",
  success: function (data) {
    var orders = data;
  },
});

var orders = [
  {
    date: "2/2/2020",
    time: "2 PM",
    addr: "Classroom 302",
    snack: "Tea",
    shop: "2 chaha Official",
    quantity: "2",
  },
  {
    date: "3/2/2020",
    time: "3 PM",
    addr: "Classroom 303",
    snack: "Pohe",
    shop: "Umiya Pohe",
    quantity: "2",
  },
  {
    date: "4/2/2020",
    time: "4 PM",
    addr: "Classroom 304",
    snack: "Cold Coffee",
    shop: "Cafe Creme",
    quantity: "2",
  },
];

for (var i = 0; i < orders.length; i++) {
  var appendme =
    "<tr><td>" +
    orders[i].date +
    "</td><td>" +
    orders[i].time +
    "</td><td>" +
    orders[i].addr +
    "</td><td>" +
    orders[i].snack +
    "</td><td>" +
    orders[i].shop +
    "</td><td>" +
    orders[i].quantity +
    "</td></tr>";
  $("#tablebody").append(appendme);
}
