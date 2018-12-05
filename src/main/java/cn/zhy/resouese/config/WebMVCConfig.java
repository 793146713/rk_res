package cn.zhy.resouese.config;

import cn.zhy.resouese.interceptor.InterceptorConfig;
import cn.zhy.resouese.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** @author: ZzzHhYyy @Date: 2018/11/9 11:19 */
@Configuration
// @EnableWebMvc
public class WebMVCConfig implements WebMvcConfigurer {
  /**
   * 添加conntroller
   *
   * @param registry
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("/index.html");
    registry.addViewController("/index.html").setViewName("/index.html");
    registry.addViewController("/articleDetail.html").setViewName("/articleDetail.html");
    registry.addViewController("/labelDetail.html").setViewName("/labelDetail.html");
    registry.addViewController("/articleList.html").setViewName("/articleList.html");
    registry.addViewController("/videoList.html").setViewName("/videoList.html");
    registry.addViewController("/videoDetail.html").setViewName("/videoDetail.html");
    registry.addViewController("/softList.html").setViewName("/softList.html");
    registry.addViewController("/softDetail.html").setViewName("/softDetail.html");
    registry.addViewController("/message.html").setViewName("/message.html");
    registry.addViewController("/about.html").setViewName("/about.html");
    // 后台页面
    registry.addViewController("/admin/login.html").setViewName("/admin/login.html");
    registry.addViewController("/admin/index.html").setViewName("/admin/index.html");
    registry.addViewController("/admin/wrok.html").setViewName("/admin/wrok.html");
    registry.addViewController("/admin/user/add.html").setViewName("/admin/user/add.html");
//    registry.addViewController("/admin/user/indexlist.html").setViewName("/admin/user/indexlist.html");
    registry.addViewController("/admin/user/index.html").setViewName("/admin/user/index.html");

  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 添加全局项目路径拦截器
    registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**");
    registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
  }

  //    @Override
  //    public void addResourceHandlers(ResourceHandlerRegistry registry) {
  //        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
  //
  //
  // registry.addResourceHandler("/upload/**").addResourceLocations("file:C:/lihuimu/images/res/");
  //    }

}
