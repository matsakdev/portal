package com.portal.server.repository;

import com.portal.server.dao.FridgeDao;
import com.portal.server.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class FridgeRepositoryImpl implements FridgeRepository {

    @Autowired
    FridgeDao fridgeDao;

    @Override
    public Set<Product> getProductsFromUserFridge(Long userId) {
        return fridgeDao.getProductsFromUserFridge(userId);
    }

    @Override
    public void addProductToFridge(Long userId, Long productId, Long productAmount) {
        fridgeDao.addProductToFridge(userId, productId, productAmount);
    }

    @Override
    public void deleteProductFromFridge(Long userid, Long productId, Long productAmount) {
        fridgeDao.deleteProductFromFridge(userid, productId, productAmount);
    }

    @Override
    public void setAmountOfProduct(Long userId, Long productId, Long amount) {
        fridgeDao.setAmountOfProduct(userId, productId, amount);
    }

}
