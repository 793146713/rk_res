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

$(function () {
    var mySwiper = new Swiper('.swiper-container', {
        direction: 'horizontal', // 垂直切换选项
        slidesPerView: 5,
        freeMode: true,
    });
});
