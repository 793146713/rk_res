
$(function () {
    $.ajax({
        url: "/resous/getAllbiaoqian/2",
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
    console.log(fenleiid + "++++++" + paixuid);
    $.ajax({
        url: "/resous/tiaojianChaxun",
        type: "get",
        data: {"type":2,"fenleiid": fenleiid, "paixuid": paixuid},
        success: function (result) {
            var html = "";
            if (result=="") {
                html="暂无数据！";
            }else {
                $.each(result, function (index, items) {
                    html += "<li>\n" +
                        "     <a title=\"" + items.title + "\" href=\"videoDetail.html?id="+items.id+"\">\n" +
                        "       <div class=\"img-box\">\n" +
                        "             <img src=\"" + items.thumbnailImg + "\">\n" +
                        "        </div>\n" +
                        "       <em><i class=\"layui-icon  layui-icon-play\"></i></em>\n" +
                        "            <div class=\"abs-bg\"></div>\n" +
                        "                  <div class=\"remark\">\n" +
                        "                      <h3>" + items.title + "</h3>\n" +
                        "                      <p>" + items.summary + "</p>\n" +
                        "                   </div>\n</a>\n" +
                        "  </li>";
                });
            }


            $("#mainvido").html(html);
        }
    });
}