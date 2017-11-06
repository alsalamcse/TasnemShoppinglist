package com.example.user.tasnemshoppinglist.data;

/**
 * Created by tasnem on 06/11/2017.
 * this class represent a product that be at the shopping list
 */

public class Product
{
    /**
     * the name of the product
     */
    private String name;
    private double price;
    private double amount;
    /**
     * if the product is bought.
     */
    private boolean isCompleted;
    /**
     * the path of products's image
     */
    private String imgPath;
    /**
     * a special key or id unique for each product(primary key)
     */
    private String keyId;

    /**
     *
     * @param name
     * @param price
     * @param amount
     */
    public Product(String name, double price, double amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isCompleted=false;
        imgPath=null;
    }

    public Product(String name, double price, double amount, boolean isCompleted, String imgPath, String keyId) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isCompleted = isCompleted;
        this.imgPath = imgPath;
        this.keyId = keyId;
    }

    public Product() {

    }
}
