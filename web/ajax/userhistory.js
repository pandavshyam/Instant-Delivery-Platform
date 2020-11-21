orders = []
$.ajax({
  type: 'GET',
  url: "http://localhost:8080/Donchaha/userhistory",
  datatype: 'JSON',
  success: function (data) {
    if (data) {
        orders = data;
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
              "</td></tr>";
            $("#tablebody").append(appendme);
        }
    } else {
        alert("Something went wrong, please try again later");
    }
  }
});