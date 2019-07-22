package com.dao;

import com.model.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author duanbochao
 * @creat 2019/7/20
 */

@Repository
public class MarketDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 分页查询
     * @param start
     * @param rows
     * @return
     */
    public  List<Market> getMarketByPage(Integer start,Integer rows){
        try {
            List<Market> query = jdbcTemplate.query("select * from market limit ?,?", new BeanPropertyRowMapper<Market>(Market.class), start, rows);
            return query;
        } catch (DataAccessException e) {
//            e.printStackTrace();
            return null;
        }
    }


    /**
     * 查询总记录数目
     * @return
     */
    public Integer getTotalCount(String query) {
        return  jdbcTemplate.queryForObject("select count(1) from market where theme like ?",Integer.class,new String[]{"%" + query + "%"});
    }

    /**
     *添加
     * @param market
     * @return
     */
    public int addMarket(Market market){
        return jdbcTemplate.update("insert into market set theme=?,budget=?,clue=?,description=?,summary=?",
                market.getTheme(), market.getBudget(), market.getClue(), market.getDescription(), market.getSummary());
    }

    /**
     * 修改
     * @param market
     * @return
     */
    public int updateMarket(Market market){
        return  jdbcTemplate.update("update  market set theme=?,budget=?,clue=?,description=?,summary=? where id=?",
                market.getTheme(), market.getBudget(), market.getClue(), market.getDescription(), market.getSummary(),market.getId());
    }


    /**
     * 删除操作
     * @param id
     * @return
     */
    public int deleteMarketById(Integer id){
       return jdbcTemplate.update("delete from market where id=?",id);
    }


    /**
     * 模糊查询
     * @param query
     * @return
     */
    public List<Map<String, Object>> selectMarketByLike(String query){
        String sql="select * from market where theme like ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, new String[]{"%" + query + "%"});
        return maps;
    }

}
