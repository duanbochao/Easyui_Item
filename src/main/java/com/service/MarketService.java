package com.service;

import com.dao.MarketDao;
import com.model.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author duanbochao
 * @creat 2019/7/20
 */
@Service
public class MarketService {

    @Autowired
    MarketDao marketDao;

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    public List<Market> getMarketByPage(Integer page, Integer rows){
       Integer start= (page-1)*rows;
      return   marketDao.getMarketByPage(start,rows);
    }

    /**
     * 查询总记录数
     * @return
     */
    public Integer getTotalCount(String query) {
        return  marketDao.getTotalCount(query);
    }



    /**
     *添加
     * @param market
     * @return
     */
    public int addMarket(Market market) {
       return marketDao.addMarket(market);
    }



    /**
     * 修改
     * @param market
     * @return
     */
    public int updateMarket(Market market){
       return marketDao.updateMarket(market);
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    public int deleteMarketById(Integer id){
        return  marketDao.deleteMarketById(id);
    }



    public List<Map<String, Object>> selectMarketByLike(String query){
      return   marketDao.selectMarketByLike(query);
    }

}
