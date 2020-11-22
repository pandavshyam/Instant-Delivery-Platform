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

