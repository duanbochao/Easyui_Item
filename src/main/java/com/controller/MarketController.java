package com.controller;

import com.model.GridData;
import com.model.Market;
import com.model.RespBean;
import com.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author duanbochao
 * @creat 2019/7/20
 */
@RestController
public class MarketController {

    @Autowired
    MarketService marketService;

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/getMarketByPage")
  private GridData getMarketByPage(Integer page,Integer rows,String query){
      List<Market> markets = marketService.getMarketByPage(page, rows);
      Integer total = marketService.getTotalCount(query);
      if (markets!=null){
          return new GridData(total,markets);
      }
      return null;
  }

    /**
     * 添加
     * @param market
     * @return
     */
  @RequestMapping("/addMarket")
    public RespBean addMarket(Market market) {
      int flag = marketService.addMarket(market);
      if (flag>0){
          return RespBean.ok(1);
      }else {
          return RespBean.error();
      }
  }

    /**
     * 修改操作
     * @param market
     * @return
     */
    @RequestMapping("/updateMarket")
  public RespBean updateMarket(Market market){
      int flag = marketService.updateMarket(market);
      if (flag>0){
          return RespBean.ok(1);
      }else {
          return RespBean.error();
      }
  }

    /**
     * 删除操作
     */
    @RequestMapping("/deleteMarketById")
    public RespBean deleteMarketById(Integer id){
        int flag = marketService.deleteMarketById(id);
        if (flag>0){
            return RespBean.ok(1);
        }else {
            return RespBean.error();
        }

    }

    @RequestMapping("/selectMarketByLike")
    public GridData selectMarketByLike(String query){
        List<Map<String, Object>> list = marketService.selectMarketByLike(query);
        Integer total = marketService.getTotalCount(query);
        return new GridData(total,list);
    }


}
