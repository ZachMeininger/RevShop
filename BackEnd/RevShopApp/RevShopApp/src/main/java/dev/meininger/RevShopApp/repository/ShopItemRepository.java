package dev.meininger.RevShopApp.repository;

import dev.meininger.RevShopApp.entity.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {

    //List<ShopItem> findShopItems();

    ShopItem findShopItemByItemId(long ItemId);

    List<ShopItem> findShopItemByItemNameContains(String item);

    List<ShopItem> findShopItemByItemDescriptionContains(String tag);
}
