package dev.meininger.RevShopApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;

    private Integer userId;

    private Integer itemId;

    private String itemName;

    private Integer itemQuantity;

    public CartItem() {

    }

    public CartItem(Integer UserId, Integer ItemId, String ItemName, Integer ItemQuantity) {
        this.userId = UserId;
        this.itemId = ItemId;
        this.itemName = ItemName;
        this.itemQuantity = ItemQuantity;
    }

    public CartItem(Integer CartId, Integer UserId, Integer ItemId, String ItemName, Integer ItemQuantity) {
        this.cartId = CartId;
        this.userId = UserId;
        this.itemId = ItemId;
        this.itemName = ItemName;
        this.itemQuantity = ItemQuantity;
    }

    public Integer getCartId() { return cartId; }

    public void setCartId(Integer CartId) {this.cartId = CartId; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer UserId) {
        this.userId = UserId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer ItemId) {
        this.itemId = ItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String ItemName) {
        this.itemName = ItemName;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer ItemQuantity) {
        this.itemQuantity = ItemQuantity;
    }

}
