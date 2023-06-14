// if you wanna using function in thymeleaf, you must not be use document.ready
function getDetailData(regYm) {
        $.ajax({
                  type: "get",
                  url: "/detail/" + regYm,
                  success: function (data) {
                          console.log(data);
                          //TODO: show popup table
                  }
        });
};

function regDetailData(regYm) {
        $.ajax({
                  type: "post",
                  url: "/detail",
                  contentType: 'application/json',
                  data:  JSON.stringify({
                            "amount": 100000,
                            "useCode": "FIX",
                            "etc": "TEST",
                            "regYm": regYm
                  }),
                  success: function (data) {
                          console.log(data);
                          //TODO: show popup table
                  }
        });
};