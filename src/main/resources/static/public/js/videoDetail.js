
var id;
function initVideo(id,url) {
    this.id= id;
    $.ajax({
        url: url + id,
        type: "get",
        data: {},
        success: function (result) {
            var html = "";
            var html2 = "";
            html += "<h1>" + result.title + "</h1>\n" +
                "<div class=\"video-jieshao\">\n" +
                result.summary +
                "</div>\n" +
                "<div class=\"detail-about_tips\">\n" +
                result.description +
                "</div> " +
                "<div id='videoResult' class=\"detail-body video\" style=\"min-height: auto!important;\">\n" +
                result.resouceVideo[0].url +
                "</div>";

            $.each(result.resouceVideo, function (index, datas) {
                if (index == 0) {
                    html2 += "<li class=\"active\" videoid='" + datas.orderSort + "'>" + datas.orderSort + "</li>";
                } else {
                    html2 += "<li videoid='" + datas.orderSort + "'>" + datas.orderSort + "</li>";
                }

            });

            $("#videomainjieshao").html(html);
            $("#vidojishu").html(html2);

            $("#vidojishu li").click(function () {
                $("#vidojishu li").removeClass("myactive");
                $(this).addClass("myactive");
                respVideo(id);
            });
        }
    })
}
function respVideo() {
    var active = $(".myactive").attr("videoid");
    // var videoid = [[${#httpServletRequest.getParameter('id')}]];
    $.ajax({
        url: "/video/getOneVideo",
        type: "get",
        data: {"active": active, "id": id},
        success: function (result) {
            $("#videoResult").html(result.url);
        }
    })
}