package com.workstudy.ssm.service;

import com.workstudy.ssm.model.ClassInfo;
import com.workstudy.ssm.model.User;
import com.workstudy.ssm.utils.ResponseData;

import java.util.List;
import java.util.Map;

/**
 * Created by Alander on 2017/7/30.
 */
public interface UserService {
    Map<String, Object> checkLogin(User user);

    String createUser(User user);

    User getUserInfoById(String studentId);

    List<User> getUsersByClass(ClassInfo classInfo);

    List<User> getAll();

    String delById(String studentId);

    String resetPwdById(String id, String pwd);

    ResponseData resetPwd(String id, String oldpwd, String newpwd);
}
