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

function saveData() {
        var fix = $('#fix').val();
        var fluct = $('#fluct').val();
        var etc = $('#etc').val();
        $.ajax({
                  type: "post",
                  url: "/save",
                  contentType: 'application/json',
                  data:  JSON.stringify({
                            "fix": fix,
                            "fluct": fluct,
                            "etc": etc
                  }),
                  success: function () {
                        alert("저장하였습니다.");
                        $('#fix').val('');
                        $('#fluct').val('');
                        $('#etc').val('');
                        $('#staticBackdrop').modal('hide');
                  }
        });
};