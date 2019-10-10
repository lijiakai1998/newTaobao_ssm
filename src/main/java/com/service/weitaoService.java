package com.service;

import com.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface weitaoService {
    public int zhuce(administrators administrators);
    user query(String name,String password);
    administrators adminSelect(String dname);
    administrators adminLogin(String dName,String dPassword);
    List<user> userList();
    List<user> userList2(user user);
    int xiugai1(user user);
    user chankan2( Integer uid);
    int shanChu1(Integer uid);
    int userAdd(user user);
    int addGoods(goods goods);
     boolean  addGoodOne(goods goods);
     List<goods> showAllGoods();
     void delGoodByIdOne(int gId);
     goods showOneGoodsById(int gId);
     boolean updateGoodsById(goods goods);
    List<appraise> showAllBuys();
    void delBuysById(int aId);
    List<appraise> search(appraise appraise);
    List<goods> goods();
    goods buy1(Integer gid);
    int insert1(dingdan dingdan);
    public void delGoodById(Integer gId);
    public void updateGoods(goods goods);
}
