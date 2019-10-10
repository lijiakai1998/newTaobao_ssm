package com.service;

import com.entity.shoppingCat;

import java.util.List;

public interface shoppingCartService {

    public boolean insertIntoShoppingCart(shoppingCat shoppingCart);
    public List<shoppingCat> showAllShoppingGoods();
    public void delShoppingGoodsByGid(int sGid);
}
