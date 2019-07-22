package com.dao;

import com.model.Menu;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author duanbochao
 * @creat 2019/7/17
 */
@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 通过用户名登录
     *
     * @param username
     * @return
     */
    public User loadUserByUsername(String username) {
        try {
            return jdbcTemplate.queryForObject("select * from user where username=?", new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
            return null;
        }
    }




}

