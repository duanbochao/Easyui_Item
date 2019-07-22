package com.dao;

import com.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author duanbochao
 * @creat 2019/7/18
 */
@Repository
public class MenuDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    /**
     * 根据用户Id查询一级菜单
     * @param uid
     * @return
     */
    public List<Menu> getMenusByUserId(Integer uid) {
        List<Menu> query = jdbcTemplate.query("select * from menu where id in(select m.parentId from " +
                "menu m where id in(select mr.mid from menu_role mr where rid in(select ur.rid from user_role ur where uid=?)))", new BeanPropertyRowMapper<Menu>(Menu.class), uid);
        return  query;
    }

    /**
     * 根据uid和pid查询二级菜单
     * @param uid
     * @param pid
     * @return
     */
    public List<Menu> getMenusByParentId(Integer uid,Integer pid) {
        List<Menu> query = jdbcTemplate.query("select m.* from menu m  where id in(select mr.mid from menu_role mr where rid in(select ur.rid from user_role ur where uid=?)) and m.parentId=?", new BeanPropertyRowMapper<Menu>(Menu.class), uid,pid);
        return  query;
    }
}
