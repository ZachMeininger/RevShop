package dev.meininger.RevShopApp.repository;

import dev.meininger.RevShopApp.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findCartItemsByUserId(long UserId);

    List<CartItem> findCartItemsByItemId(long ItemId);

}
