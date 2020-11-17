$.ajax({
  type: "get",
  url: "/boyorders",
  success: function (data) {
    var orders = data;
  },
});

var orders = [
  {
    id: "1",
    snack: "Tea",
    shop: "2 chaha Official",
    quantity: "2",
    name: "Dhanesh Pawar",
    mobile: "90289619149",
    addr: "Classroom 302",
  },
  {
    id: "2",
    snack: "Pohe",
    shop: "Umiya Pohe",
    quantity: "2",
    name: "Dhanesh Pawar",
    mobile: "90289619149",
    addr: "Classroom 303",
  },
  {
    id: "3",
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
    "</td><td>" +
    "<button type='button' class='btn btn-green row-select-submit' onclick='mark(" +
    orders[i].id +
    ")'>Mark as delivered</button>" +
    "</td></tr>";
  $("#tablebody").append(appendme);
}

function mark(id) {
  $.ajax({
    type: "post",
    url: "/mark",
    data: { id: id },
    success: function (data) {
      window.location.reload();
    },
  });
}
