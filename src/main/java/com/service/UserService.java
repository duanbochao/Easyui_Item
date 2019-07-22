package com.service;

import com.dao.UserDao;
import com.model.Menu;
import com.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanbochao
 * @creat 2019/7/17
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    /**
     * 登录
     * @param user
     * @return
     */
    public User loadUserByUsername(User user){
        User loginUser = userDao.loadUserByUsername(user.getUsername());
        if (loginUser==null){
            System.out.println("用户名不存在");
            return null;
        }else {
            if (DigestUtils.md5Hex(user.getPassword()).equals(loginUser.getPassword())){
                return loginUser;
            }
            System.out.println("密码不正确");
        }

        return null;
    }



}
