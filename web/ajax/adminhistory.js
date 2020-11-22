$.ajax({
  type: "get",
  url: "http://localhost:8080/Donchaha/adminhistory",
  datatype:'JSON',
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
          "</td><td>" +
          orders[i][5] +
          "</td></tr>";
        $("#tablebody").append(appendme);
    }
  },
});

//var orders = [
//  {
//    date: "2/2/2020",
//    snack: "Tea",
//    quantity: "2",
//    name: "Dhanesh Pawar",
//    addr: "Classroom 302",
//  },
//  {
//    date: "3/2/2020",
//    time: "3 PM",
//    snack: "Pohe",
//    shop: "Umiya Pohe",
//    quantity: "2",
//    name: "Dhanesh Pawar",
//    addr: "Classroom 303",
//  },
//  {
//    date: "4/2/2020",
//    time: "4 PM",
//    snack: "Cold Coffee",
//    shop: "Cafe Creme",
//    quantity: "2",
//    name: "Dhanesh Pawar",
//    addr: "Classroom 304",
//  },
//];
