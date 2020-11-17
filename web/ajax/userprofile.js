$.ajax({
  type: "get",
  url: "/userprofile",
  success: function (data) {
    var profile = data;
  },
});

var profile = {
  name: "Dhanesh Pawar",
  email: "dhaneshpawar.me@gmail.com",
  mobile: "90289619149",
  addr: "Classroom 4",
};

$("#name").val(profile.name);
$("#email").val(profile.email);
$("#mobile").val(profile.mobile);
$("#addr").val(profile.addr);

function saveInfo() {
  alert("you cliked on it");
  var profile = {
    name: "",
    email: "",
    mobile: "",
    addr: "",
  };

  profile.name = $("#name").val();
  profile.email = $("#email").val();
  profile.mobile = $("#mobile").val();
  profile.addr = $("#addr").val();

  console.log("to send profile ", profile);

  $.ajax({
    type: "post",
    url: "/setprofile",
    data: profile,
    success: function (data) {
      var profile = data;
    },
  });
}
