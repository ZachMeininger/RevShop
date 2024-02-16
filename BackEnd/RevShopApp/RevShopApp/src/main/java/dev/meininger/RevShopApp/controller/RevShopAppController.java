package dev.meininger.RevShopApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.meininger.RevShopApp.entity.BuyerAccount;
import dev.meininger.RevShopApp.entity.CartItem;
import dev.meininger.RevShopApp.entity.ShopItem;
import dev.meininger.RevShopApp.service.BuyerAccountService;
import dev.meininger.RevShopApp.service.CartItemService;
import dev.meininger.RevShopApp.service.ShopItemService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RevShopAppController {
    @Autowired
    BuyerAccountService buyeraccountService;
    @Autowired
    CartItemService cartitemService;
    @Autowired
    ShopItemService shopitemService;

    @CrossOrigin
    @PostMapping(value = "/register")
    public ResponseEntity<BuyerAccount> registrationHandler(@RequestBody BuyerAccount buyeraccount) throws JsonProcessingException
    {
        if(buyeraccount.getUserEmail().length() == 0 || buyeraccount.getUserEmail().length() > 254 || buyeraccount.getUserPassword().length() < 4)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        else
        {
            BuyerAccount accountCheck = buyeraccountService.addBuyerAccount(buyeraccount);
            if(accountCheck != null)
            {
                return ResponseEntity.ok(accountCheck);
            }
            else
            {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(accountCheck);
            }
        }
    }

    @CrossOrigin
    @PostMapping(value = "/login")
    public ResponseEntity<BuyerAccount> loginHandler(@RequestBody BuyerAccount buyeraccount) throws JsonProcessingException
    {
        BuyerAccount accountCheck = buyeraccountService.loginBuyerAccount(buyeraccount);
        if(accountCheck != null)
        {
            return ResponseEntity.ok(accountCheck);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(accountCheck);
    }

    @CrossOrigin
    @GetMapping(value = "/shopitems")
    public ResponseEntity<List<ShopItem>> getAllShopItemsHandler() throws JsonProcessingException
    {
        List<ShopItem> shopitems = shopitemService.getAllShopItems();
        if(shopitems != null)
        {
            return ResponseEntity.ok(shopitems);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @CrossOrigin
    @GetMapping(value = "/shopitem/{item_id}")
    public ResponseEntity<ShopItem> getShopItemByIdHandler(@PathVariable int item_id) throws JsonProcessingException
    {
        ShopItem shopitem = shopitemService.getShopItemByItemId(item_id);
        if(shopitem != null)
        {
            return ResponseEntity.ok(shopitem);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @CrossOrigin
    @GetMapping(value = "/shopitems/{item_name}")
    public ResponseEntity<List<ShopItem>> getShopItemsByContainsHandler(@PathVariable String item_name) throws JsonProcessingException
    {
        List<ShopItem> shopitems = shopitemService.getShopItemByContains(item_name);
        if(shopitems != null)
        {
            return ResponseEntity.ok(shopitems);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @CrossOrigin
    @GetMapping(value = "/shopitemstag/{item_tag}")
    public ResponseEntity<List<ShopItem>> getShopItemsByContainsTagHandler(@PathVariable String item_tag) throws JsonProcessingException
    {
        List<ShopItem> shopitems = shopitemService.getShopItemByContainsTag(item_tag);
        if(shopitems != null)
        {
            return ResponseEntity.ok(shopitems);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @CrossOrigin
    @PostMapping(value = "/addToCart")
    public ResponseEntity<CartItem> addToCartHandler(@RequestBody CartItem cartitem) throws JsonProcessingException
    {
        CartItem itemCheck = cartitemService.addCartItem(cartitem);
        if(itemCheck != null)
        {
            return ResponseEntity.ok(itemCheck);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @CrossOrigin
    @DeleteMapping(value = "/cart/{id}")
    public ResponseEntity<CartItem> deleteCartItemHandler(@PathVariable int id)
    {
        CartItem itemCheck = cartitemService.deleteCartItemById(id);
        if(itemCheck != null)
        {
            return ResponseEntity.ok(itemCheck);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @CrossOrigin
    @DeleteMapping(value = "/emptycart/{id}")
    public ResponseEntity<List<CartItem>> deleteAllCartItemsHandler(@PathVariable int id)
    {
        List<CartItem> itemsCheck = cartitemService.deleteCartItemsById(id);
        if(itemsCheck != null)
        {
            return ResponseEntity.ok(itemsCheck);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @CrossOrigin
    @GetMapping(value = "/accounts/{account_id}/cartitems")
    public ResponseEntity<List<CartItem>> getAllCartItemsById(@PathVariable int account_id)
    {
        List<CartItem> cartitems = cartitemService.getAllCartItemsByUserId(account_id);
        if(cartitems != null)
        {
            return ResponseEntity.ok(cartitems);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
