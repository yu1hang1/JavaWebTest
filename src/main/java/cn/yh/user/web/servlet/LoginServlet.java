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

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        UserService userService = new UserService();
        User form = new User();
        try {
            BeanUtils.populate(form, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            User user1 = userService.login(form);
            request.getSession().setAttribute("sessionUser", user1);
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("user", form);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
