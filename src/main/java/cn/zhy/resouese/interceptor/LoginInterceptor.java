package cn.zhy.resouese.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** @author: ZzzHhYyy @Date: 2018/11/27 10:31 */
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws IOException, ServletException {

    String contextPath = request.getRequestURI();
    if (contextPath.contains(".html")) System.out.println(contextPath);
    if (contextPath.contains("admin")) {
      if (request.getSession().getAttribute("loginUser") != null) {
        return true;
      } else if (contextPath.contains("admin/login.html")
          || contextPath.contains("login_admin.css")) {
        return true;
      } else {
        request.setAttribute("msg", "请登录后重试！");
        request.getRequestDispatcher("/admin/login.html").forward(request, response);
        return false;
      }
    }
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {}

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {}
}
