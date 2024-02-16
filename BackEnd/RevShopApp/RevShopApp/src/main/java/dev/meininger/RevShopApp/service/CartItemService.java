package dev.meininger.RevShopApp.service;

import dev.meininger.RevShopApp.entity.CartItem;
import dev.meininger.RevShopApp.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class CartItemService {
    @Autowired
    CartItemRepository cartitemRepository;

    @Transactional
    public CartItem addCartItem(CartItem cartitem) {
        return cartitemRepository.save(cartitem);
    }

    @Transactional
    public List<CartItem> getAllCartItemsByUserId(long id)
    {
        List<CartItem> cartitems = cartitemRepository.findCartItemsByUserId(id);
        if(cartitems != null)
        {
            return cartitems;
        }
        return null;
    }

    @Transactional
    public CartItem deleteCartItemById(long id)
    {
        List<CartItem> cartItems = cartitemRepository.findCartItemsByItemId(id);
        if(cartItems != null)
        {
            for(int i = 0; i<cartItems.size(); i++)
            {
                cartitemRepository.delete(cartItems.get(i));
            }
            return cartItems.get(0);
        }
        return null;
    }

    @Transactional
    public List<CartItem> deleteCartItemsById(long id)
    {
        List<CartItem> cartitems = cartitemRepository.findCartItemsByUserId(id);
        if(cartitems != null)
        {
            for(int i = 0; i< cartitems.size(); i++)
            {
                cartitemRepository.delete(cartitems.get(i));
            }
            return cartitems;

        }
        return null;
    }
}
