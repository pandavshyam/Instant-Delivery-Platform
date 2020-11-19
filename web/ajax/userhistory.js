var orders;
$.ajax({
  type: 'GET',
  url: "http://localhost:8080/Donchaha/userhistory",
//  datatype: 'JSON',
  success: function (data) {
    if (data) {
        orders = data;
        console.log(data);
        alert(data);
    } else {
        alert("Something went wrong, please try again later");
    }
  }
});

//var orders = [
//  {
//    date: "2/2/2020",
//    addr: "Classroom 302",
//    snack: "Tea",
//    quantity: "2",
//  },
//  {
//    date: "3/2/2020",
//    addr: "Classroom 303",
//    snack: "Pohe",
//    quantity: "2",
//  },
//  {
//    date: "4/2/2020",
//    addr: "Classroom 304",
//    snack: "Cold Coffee",
//    quantity: "2",
//  },
//];

for (var i = 0; i < orders.length; i++) {
  var appendme =
    "<tr><td>" +
    orders[i].date +
    "</td><td>" +
    orders[i].addr +
    "</td><td>" +
    orders[i].snack +
    "</td><td>" +
    orders[i].quantity +
    "</td></tr>";
  $("#tablebody").append(appendme);
}
