$(function () {
    //精选推荐加载
    layui.use('flow', function () {
        var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        var flow = layui.flow;
        flow.load({
            elem: '.content-main', //指定列表容器
            done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.get('/resous/tuijian?pageIndex=' + page, function (res) {
                    var name = "";
                    layui.each(res.data.records, function (index, item) {
                        if (item.resouceCatalog == null) {
                            name = "无分类";
                        } else {
                            name = item.resouceCatalog.name;
                        }
                        var html = "";
                        html += "<li class=\"content-item\">" +
                            "<div class=\"layui-col-md4 left\">" +
                            "<img src='" + item.thumbnailImg + "'/>" +
                            "</div>" +
                            "<div class=\"layui-col-md8 info\">" +
                            "<h2><a class=\"zidingyi-badge\">" + name + "</a><a href='articleDetail.html?id=" + item.id + "'>" + item.title + "</a>" +
                            "</h2>" +
                            "<p class=\"summary\">" + item.summary +
                            "</p>" +
                            "<div class='meta\'>" +
                            "<div class='meta-left'>" +
                            "<a>" +
                            "<i class=\"layui-icon layui-icon-username\"></i>" + item.author +
                            "</a>" +
                            "</div>" +
                            "<div class=\"meta-right\">" +
                            "<a><i class=\"layui-icon\">&#xe705;</i><span class=\"num\">" + item.clickCount + "</span></a>" +
                            "<span><i class=\"layui-icon layui-icon-log\"></i>" + item.addTime + "</span>" +
                            "</div>" +
                            "</div>" +
                            "</div>" +
                            "</li>";
                        lis.push(html);
                    });
                    //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                    //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                    next(lis.join(''), page < res.pages);
                });
            }
        });
    });
    /**
     * 热门标签
     */
    $.ajax({
        url: "/resous/biaoqian",
        type: "get",
        success: function (data) {
            var html = "";
            $.each(data, function (index, data) {
                html += "<a class='animated3' href='/labelDetail.html?id=" + data.id + "' title=\"" + data.name + "\" style=\"background-color: " + data.color + ";\">" + data.name + "</a>";
            });
            $("#fenyeleibie").html(html);
        }
    });
    /**
     * 广告
     */
    $.ajax({
        url: "/resous/guanggao",
        type: "get",
        success: function (data) {
            var html = "";
            $.each(data, function (index, data) {
                html += "<div>" +
                    "<img title='" + data.name + "' src='" + data.adImg + "'/>" +
                    "</div>";
            });
            $("#guanggao").html(html);
            layui.use(['carousel', 'element'], function () {
                var element = layui.element;
                var carousel = layui.carousel;
                carousel.render({
                    elem: '#brand'
                    , width: '100%' //设置容器宽度
                    , height: '160px'
                    , arrow: 'always' //始终显示箭头
                    , indicator: 'always'
                    , anim: 'fade' //切换动画方式
                });
            });
        }
    });
    $("#tab li").click(function () {
        $("#tab li").removeClass("active");
        $(this).addClass("active");
    });
    paihang(1);
    /**
     * 推荐视频
     */
    $.ajax({
        url: "/resous/tuijianvideo",
        type: "get",
        data: {},
        success: function (data) {

            var html = "";
            $.each(data, function (index, items) {
                $.each(items.resouceVideo, function (index, item) {
                    html += "<li>\n" +
                        "<a href='" + item.url + "' title='" + item.title + "'>" +
                        "<img src='" + items.thumbnailImg + "'" +
                        " title='" + item.title + "'>" +
                        "<b>" + item.title + "</b>" +
                        "</a>\n" +
                        "<p>\n" +
                        "<span class=\"tutime\">\n" +
                        "<i class=\"layui-icon layui-icon-log\"></i>\n" + items.addTime +
                        "</span>\n" +
                        "</p>\n" +
                        "</li>";
                });
            });
            $(".voide-list").html(html)
        }
    });
    /**
     * 友情链接
     */
    $.ajax({
        url: "/resous/youqing",
        type: "get",
        data: {},
        success: function (data) {
            var html = "";
            // $("#tuijian").empty();
            $.each(data, function (index, items) {
                html += "<a style='color: #00FFFF;' href=\"" + items.url + "\" target=\"_blank\">" + items.name + "</a><br/><hr>";
            });
            $("#tuijian").html(html);
        }

    })
});

//排行
function paihang(obj) {
    $.ajax({
        url: "/resous/paihang/" + obj,
        data: {},
        success: function (data) {
            var html = "";
            $.each(data, function (index, items) {
                html += "<li>\n" +
                    "<span class=\"layui-badge\">" + (index + 1) + "</span>\n" +
                    "<a href='articleDetail.html?id=" + items.id + "'>" + items.title + "</a>" +
                    "</li>";
            });
            $(".news-list").html(html);
        }
    })
}
