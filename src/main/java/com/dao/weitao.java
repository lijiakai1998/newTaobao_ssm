package com.dao;

import com.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface weitao {
     int zhuce(administrators administrators);
     user query(@Param("name") String name,@Param("pass") String password);
     administrators adminSelect(@Param("dname") String name);
     administrators adminLogin(@Param("dName") String dName,@Param("dPassword") String dPassword);
     List<user> userList();
     List<user> userList2(user user);
     int xiugai1(user user);
     user chankan2(@Param("uid") Integer uid);
     int shanChu1(@Param("uid") Integer uid);
     int userAdd(user user);
     int addGoods(goods goods);
      List<appraise> showAllBuys();
      void delBuysById(int aId);
      List<appraise> search(appraise appraise);
      List<goods> goods();
      goods buy1(@Param("gid") Integer gid);
      int insert1(dingdan dingdan);
      public void delGoodById(Integer gId);
      public void updateGoods(goods goods);

      /*购物车*/
       public void insertIntoShoppingCart(shoppingCat shoppingCart);
       public List<shoppingCat> showAllShoppingGoods();
       public void delShoppingGoodsByGid(int sGid);
       public List<goods> showAllGoods();
       public void delGoodById(int gId);
       public goods showOneGoodsById(int gId);
       public void updateGoodsById(goods goods);
       public void addGood(goods goods);

}
