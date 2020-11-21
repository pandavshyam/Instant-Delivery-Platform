$.ajax({
  type: "get",
  url: "http://localhost:8080/Donchaha/boyindex",
  datatype : 'JSON',
  success: function (data) {
    var orders = data;
    console.log(data);
    
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
        "<button type='button' class='btn btn-green row-select-submit' onclick='mark(" +
         '"' + orders[i][5].$oid + '"' +
        ");'>Mark as delivered</button>" +
        "</td></tr>";
      $("#tablebody").append(appendme);
    }
  },
});



function mark(id) {
    if (window.confirm('Confirm again please '))
    {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/Donchaha/boyindex",
            datatype : 'JSON',
            data: { "id": id },
            success: function (data) {
              console.log(data);
            },
        });
    }
    else
    {
        console.log("OK");
    }
}
