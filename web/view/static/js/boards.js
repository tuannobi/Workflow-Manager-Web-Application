$(document).ready(function () {

    $(document).on('click','#board-display-create',function (e) {
        e.preventDefault();
        $('#background-popup').removeClass("hide");
    })

    $(document).on('submit','#form',function (e) {
        e.preventDefault();
        $.ajax({
            url:"createBoard",
            type:"POST",
            data:$('#form').serialize(),
            dataType: "json",
            // contentType: false,
            // cache: false,
            // processData:false,
            success: function(res){
                alert(res.alert);
                if (res.alert==true){
                    $(res.code).insertBefore('#board-display-create-a');
                }

            }
        })
    })

    $(document).on('click','input[name="board-popup-create-body-cancel"]',function () {
        $('input[name="board-popup-create-title"]').val("");
        $('input[name="board-popup-create-body-start"]').val("");
        $('input[name="board-popup-create-body-end"]').val("");
        $('textarea[name="board-popup-create-body-description"]').val("");
        $('#background-popup').addClass("hide");
    })
})