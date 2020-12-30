package cn.yh.user.cn.yh.user.service;
import cn.yh.user.cn.yh.user.dao.UserDao;
import cn.yh.user.cn.yh.user.domain.User;



public class UserService {
    public void register(User user) throws UserException{
        UserDao userDao = new UserDao();
        User _user = userDao.findByUsername(user.getUsername());
        if(_user!=null) throw new UserException("用户名"+ user.getUsername() + ",已经注册");

        userDao.addUser(user) ;//当密码为空时，如何捕获异常
    }

    public User login(User form) throws UserException {
        UserDao userDao = new UserDao();
        User user = userDao.findByUsername(form.getUsername());

        if(user == null) throw new UserException("用户不存在！");
        if(!form.getPassword().equals(user.getPassword())){
            throw new UserException("密码错误！");
        }
        return user;
    }
}
