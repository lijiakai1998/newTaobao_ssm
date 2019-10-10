package com.service.weitaoServiceImpl;

import com.dao.weitao;
import com.entity.*;
import com.service.weitaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class weitaoServiceImpl implements weitaoService {
    @Autowired
    private weitao weitao;

    public int zhuce(administrators administrators){
        return weitao.zhuce(administrators);
    }
    public user query(String name, String password){
        return weitao.query(name,password);
    }
    public   administrators adminSelect(String dname){
        return weitao.adminSelect(dname);
    }
    public administrators adminLogin(String dName,String dPassword){
        return weitao.adminLogin(dName,dPassword);
    }
    public List<user> userList(){
        return weitao.userList();
    }
    public List<user> userList2(user user){
        return weitao.userList2(user);
    }
    public int xiugai1(user user){
        return weitao.xiugai1(user);
    }
    public user chankan2( Integer uid){
        return weitao.chankan2(uid);
    }
    public int shanChu1(Integer uid){
        return weitao.shanChu1(uid);
    }
    public int userAdd(user user){
        return weitao.userAdd(user);
    }

    @Override
    public int addGoods(goods goods) {
        return weitao.addGoods(goods);
    }

    @Override
    public boolean addGoodOne(goods goods) {
        weitao.addGood(goods);
        return true;
    }

    @Override
    public List<goods> showAllGoods() {
        return weitao.showAllGoods();
    }

    @Override
    public void delGoodByIdOne(int gId) {
        weitao.delGoodById(gId);
    }

    @Override
    public goods showOneGoodsById(int gId) {
        return weitao.showOneGoodsById(gId);
    }

    @Override
    public boolean updateGoodsById(goods goods) {
        weitao.updateGoodsById(goods);
        return true;
    }

    @Override
    public List<appraise> showAllBuys() {
        return weitao.showAllBuys();
    }

    @Override
    public void delBuysById(int aId) {
        weitao.delBuysById(aId);
    }

    @Override
    public List<appraise> search(appraise appraise) {
        return weitao.search(appraise);
    }

    @Override
    public List<goods> goods() {
        return weitao.goods();
    }

    @Override
    public goods buy1(Integer gid) {
        return weitao.buy1(gid);
    }

    @Override
    public int insert1(dingdan dingdan) {
        return weitao.insert1(dingdan);
    }

    @Override
    public void delGoodById(Integer gId) {
        weitao.delGoodById(gId);
    }

    @Override
    public void updateGoods(goods goods) {
        weitao.updateGoods(goods);
    }

}
