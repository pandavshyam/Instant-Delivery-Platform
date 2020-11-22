$.ajax({
  type: "get",
  datatype: 'JSON',
  url: "http://localhost:8080/Donchaha/profile",
  success: function (data) {
    $("#name").val(data[1]);
    $("#email").val(data[3]);
    $("#mobile").val(data[4]);
    $("#addr").val(data[5]);
  },
});

function saveInfo() {
  var profile = {
    name: "",
    email: "",
    mobile: "",
    address: "",
  };

  profile.name = $("#name").val();
  profile.email = $("#email").val();
  profile.mobile = $("#mobile").val();
  profile.address = $("#addr").val();

//  console.log(JSON.stringify(profile));
   
  $.ajax({
    type: "post",
    datatype:'JSON',
    url: "http://localhost:8080/Donchaha/profile",
    data: {"email" : profile.email,
            "name": profile.name,
            "mobile": profile.mobile,
            "address": profile.address
            },
    success: function (data) {
      var profile = data;
      alert("Profile Updated");
    },
  });
}