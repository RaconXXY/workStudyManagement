package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.ClassInfo;
import com.workstudy.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/7/30.
 */
@Repository
public interface UserDao {
    User getUserById(@Param("userId") String userId);
    Integer createUser(@Param("user") User user);
    List<User> getUsersByClass(@Param("classInfo") ClassInfo classInfo);

    List<User> getAll();

    Integer delById(@Param("studentId") String studentId);

    Integer resetPwdById(@Param("userId") String userId, @Param("pwd") String pwd);
}
