package dev.meininger.RevShopApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShopItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    private String itemName;

    private Double itemPrice;

    private String itemPicture;

    private String itemDescription;

    public ShopItem(){

    }

    public ShopItem(String ItemName, Double ItemPrice, String ItemPicture, String ItemDescription){
        this.itemName = ItemName;
        this.itemPrice = ItemPrice;
        this.itemPicture = ItemPicture;
        this.itemDescription = ItemDescription;
    }

    public ShopItem(Integer ItemId, String ItemName, Double ItemPrice, String ItemPicture, String ItemDescription){
        this.itemId = ItemId;
        this.itemName = ItemName;
        this.itemPrice = ItemPrice;
        this.itemPicture = ItemPicture;
        this.itemDescription = ItemDescription;
    }

    public Integer getItemIdId() {
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

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double ItemPrice) {
        this.itemPrice = ItemPrice;
    }

    public String getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(String ItemPicture) {
        this.itemPicture = ItemPicture;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String ItemDescription) {
        this.itemDescription = ItemDescription;
    }
}
