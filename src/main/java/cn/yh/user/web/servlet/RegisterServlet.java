package cn.yh.user.web.servlet;

import cn.yh.user.cn.yh.user.domain.User;
import cn.yh.user.cn.yh.user.service.UserException;
import cn.yh.user.cn.yh.user.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserService userService = new UserService();
        User user =new User();

        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            userService.register(user);
            response.getWriter().print("<h1>注册成功！</h1><a href='" + request.getContextPath() +"/login.jsp "+"'>点击这里去登陆</a>");
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Sevelet执行了！");

    }
}
