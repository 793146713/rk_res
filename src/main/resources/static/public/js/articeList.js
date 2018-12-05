$(function () {
    $.ajax({
        url: "/resous/getAllbiaoqian/1",
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
                $("#showAll").append(html);
                $("#showAll a").click(function () {
                    $("#showAll a").removeClass("c-active");
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
        data: {"type": 1, "fenleiid": fenleiid, "paixuid": paixuid},
        success: function (result) {
            var html = "";
            $.each(result, function (index, items) {
                html += "<div class=\"layui-card\" style=\"overflow: hidden;\">\n" +
                    "                <div class=\"layui-card-body content-item\">\n" +
                    "                    <div class=\"layui-col-md4 left\">\n" +
                    "                        <img src='" + items.thumbnailImg + "'>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"layui-col-md8 info\">\n" +
                    "                        <h2><a href=\"articleDetail.html?id=" + items.id + "\">" + items.title + "</a></h2>\n" +
                    "                        <p class=\"summary\">\n" + items.summary +
                    "                        </p>\n" +
                    "                        <div class=\"meta\">\n" +
                    "                            <div class=\"meta-left\">\n" +
                    "                                <a>\n" +
                    "                                    <i class=\"layui-icon layui-icon-username\"></i>" + items.author +
                    "                                </a>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"meta-right\">\n" +
                    "                                <a><i class=\"layui-icon\"></i><span class=\"num\"> " + items.clickCount + "</span></a>\n" +
                    "                                <span><i class=\"layui-icon layui-icon-log\"></i>" + items.addTime + "</span>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>";
            });
            $("#mainData").html(html);
        }
    })
}