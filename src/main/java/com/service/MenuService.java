package com.service;

import com.dao.MenuDao;
import com.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanbochao
 * @creat 2019/7/18
 */
@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;
    /**
     * 根据用户id查询一级菜单
     * @param uid
     * @return
     */

    public List<Menu> getMenusByUserId(Integer uid) {
        return menuDao.getMenusByUserId(uid);
    }


    /**
     * 根据uid和pid来查询二级菜单
     * @param uid
     * @param pid
     * @return
     */
    public List<Menu> getMenusByParentId(Integer uid,Integer pid) {
        return menuDao.getMenusByParentId(uid,pid);
    }
}
