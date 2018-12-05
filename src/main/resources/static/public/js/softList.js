$(function () {
    $.ajax({
        url: "/resous/getAllbiaoqian/3",
        type: "get",
        data: {},
        success: function (data) {
            if (data == null) {
                alert("网络连接失败！")
            } else {
                var html = "";
                $.each(data, function (index, item) {
                    html += "<a style='color:" + item.color + "' href='javascript:void(0)' fenleiid=\"" + item.id + "\">" + item.name + "</a>";
                });
                $("#fenleiVideo").append(html);
                $("#fenleiVideo a").click(function () {
                    $("#fenleiVideo a").removeClass("c-active");
                    $(this).addClass("c-active");
                    getFenlei();
                });
                $("#paixuchaxun a").click(function () {
                    $("#paixuchaxun a").removeClass("order-active");
                    $(this).addClass("order-active");
                    getFenlei();
                })
            }
        }
    });
    getFenlei();
});
var fenleiid;
var paixuid;
function getFenlei() {
    fenleiid = $(".c-active").attr("fenleiid");
    paixuid = $(".order-active").attr("paixuid");
    $.ajax({
        url: "/resous/tiaojianChaxun",
        type: "get",
        data: {"type":3,"fenleiid": fenleiid, "paixuid": paixuid},
        success: function (result) {
            var html = "";
            if (result=="") {
                html="暂无数据！";
            }else {
                $.each(result, function (index, item) {
                    console.log(item.id);
                    html += "<li><a title='"+item.title+"' href='softDetail.html?id="+item.id+"'>"+
                        "<div class='img-box'><img src='" + item.thumbnailImg + "'></div>"+
                        "<div class='info'>"+
                        "<h3>"+item.title+"</h3>"+
                        "<p><strong>"+"下载"+"</strong>"+
                        "<span>"+item.addTime+"</span>"+
                        "</p> </div> </a> </li>";
                });
            }
            $("#soft-lists").html(html);
        }
    });
}