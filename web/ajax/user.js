var orders = [];
function placeorder() {
  orders = [];
  console.log("check : ", $("#ck1").is(":checked"));
  if ($("#ck1").is(":checked")) {
    orders.push({ snack: "tea", quantity: $("#sel1").val() });
  }
  if ($("#ck2").is(":checked")) {
    orders.push({ snack: "pohe", quantity: $("#sel2").val() });
  }
  if ($("#ck3").is(":checked")) {
    orders.push({ snack: "samosa", quantity: $("#sel3").val() });
  }
  if ($("#ck4").is(":checked")) {
    orders.push({ snack: "coldcoffee", quantity: $("#sel4").val() });
  }
  console.log("orders : ", orders);

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/Donchaha/placeorder",
    dataType: 'JSON',
    data: {
      orders: JSON.stringify(orders),
    },
    success: function (data) {
      if (data) {
        alert(data);
        console.log(data);
      } else {
        alert("Something went wrong, please try again later");
      }
    },
  });
}
