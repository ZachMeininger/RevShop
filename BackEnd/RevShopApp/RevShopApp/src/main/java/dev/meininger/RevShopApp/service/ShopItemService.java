package dev.meininger.RevShopApp.service;

import dev.meininger.RevShopApp.entity.ShopItem;
import dev.meininger.RevShopApp.repository.ShopItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class ShopItemService {
    @Autowired
    ShopItemRepository shopitemRepository;

    @Transactional
    public ShopItem addShopItem(ShopItem shopitem) {
        return shopitemRepository.save(shopitem);
    }

    @Transactional
    public List<ShopItem> getAllShopItems() {
        return shopitemRepository.findAll();
    }

    @Transactional
    public ShopItem getShopItemByItemId(long id) {
        return shopitemRepository.findShopItemByItemId(id);
    }

    @Transactional
    public List<ShopItem> getShopItemByContains(String item)
    {
        return shopitemRepository.findShopItemByItemNameContains(item);
    }

    @Transactional
    public List<ShopItem> getShopItemByContainsTag(String tag)
    {
        return shopitemRepository.findShopItemByItemDescriptionContains(tag);
    }
}
