package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.controller.UserController;
import com.workstudy.ssm.dao.UserDao;
import com.workstudy.ssm.model.ClassInfo;
import com.workstudy.ssm.model.User;
import com.workstudy.ssm.service.UserService;
import com.workstudy.ssm.utils.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alander on 2017/7/30.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserDao userDao;

    @Override
    public Map<String, Object> checkLogin(User user) {
        Map<String, Object> res = new HashMap<>();
        User myUser = userDao.getUserById(user.getUserId());
        res.put("user", myUser);
        res.put("isLogin", myUser != null && user.equals(myUser));
        return res;
    }

    @Override
    public String createUser(User user) {
        if (null == userDao.getUserById(user.getUserId())) {
            if (0 != userDao.createUser(user)) {
                return "注册成功！";
            } else {
                return "注册失败！";
            }
        }
        return "该用户已被注册";
    }

    @Override
    public User getUserInfoById(String studentId) {
        return userDao.getUserById(studentId);
    }

    @Override
    public List<User> getUsersByClass(ClassInfo classInfo) {
        return userDao.getUsersByClass(classInfo);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public String delById(String studentId) {
        if (0 != userDao.delById(studentId)) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }
    }

    @Override
    public String resetPwdById(String userId, String pwd) {
        if (0 != userDao.resetPwdById(userId, pwd)) {
            return "修改成功！";
        } else return "修改失败！";
    }

    @Override
    public ResponseData resetPwd(String userId, String oldpwd, String newpwd) {
        User myUser = userDao.getUserById(userId);
        if (myUser == null) {
            return ResponseData.customerError("用户不存在!");
        }
        if (!myUser.getPassword().equals(oldpwd)) {
            return ResponseData.customerError("密码错误!");
        }
        if (0 != userDao.resetPwdById(userId, newpwd)) {
            return ResponseData.ok("修改成功!");
        }
        return ResponseData.serverInternalError("服务器错误，请稍后重试!");
    }
}
