package com.portal.server.dao;

import com.portal.server.entity.Fridge;
import com.portal.server.entity.Product;

import com.portal.server.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Transient;

import java.util.Set;

@Component
public class FridgeDaoImpl implements FridgeDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Set<Product> getProductsFromUserFridge(Long userId) {
        Query query = entityManager.createQuery("SELECT fridge FROM Fridge fridge" +
                " WHERE fridge.user.id=" + userId);
        return Set.copyOf(query.getResultList());
    }

    @Override
    @Transactional
    public void addProductToFridge(Long userId, Long productId, Long productAmount) {
        User user = entityManager.find(User.class, userId);
        Product product = entityManager.find(Product.class, productId);
        Fridge fridge = entityManager.find(Fridge.class, new Fridge.Id(userId, productId));
        if (fridge != null) {
            fridge.setAmount(fridge.getAmount() + productAmount);
        }
        else {
            fridge = new Fridge(user, product, productAmount);
        }
        entityManager.persist(fridge);
    }

    @Override
    @Transactional
    public void deleteProductFromFridge(Long userId, Long productId, Long productAmount) {
        Fridge fridgeElement = entityManager.find(Fridge.class, new Fridge.Id(userId, productId));
        if (productAmount >= fridgeElement.getAmount()) {
            entityManager.remove(fridgeElement);
        }
        else {
            fridgeElement.setAmount(fridgeElement.getAmount() - productAmount);
            entityManager.persist(fridgeElement);
        }
    }

    @Override
    @Transactional
    public void setAmountOfProduct(Long userId, Long productId, Long amount) {
        if (amount <= 0) {
            deleteProductFromFridge(userId, productId, amount);
        }
        else {
            try {
                Fridge fridge = (Fridge)entityManager.createQuery("SELECT fridge FROM Fridge fridge" +
                        " WHERE fridge.id.userId=" + userId + " AND fridge.id.productId=" + productId).getSingleResult();
                fridge.setAmount(amount);
                entityManager.persist(fridge);
            }
            catch (Exception e) {
                throw new NoResultException("Cannot find this product");
            }

        }
    }
}
