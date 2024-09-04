package exam_Advance_1_ra.business.entity;

import exam_Advance_1_ra.validate.CartValidate;

import java.util.Scanner;

public class CartItem {
    private int cartItemId;
    private Product product;
    private double price;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int cartItemId, Product product, double price, int quantity) {
        this.cartItemId = cartItemId;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //Input Data Cart
    public void inputData(Scanner sc, String productId){
        this.cartItemId = CartValidate.inputCartId();
        this.product = CartValidate.inputProduct(productId);
        this.quantity = CartValidate.inputCategoryQuantiry(sc,this.product);
        this.price = this.product.getProductPrice() * this.quantity;
    }
    //Display Cart
    public void displayData(){
        System.out.printf("ID : %3d | ProductName: %15s  | Price: %5.2f  | Quantity: %5s \n"
                ,this.cartItemId,this.product.getProductName(),this.price,this.quantity);
    }


}
