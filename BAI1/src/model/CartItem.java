package model;

public class CartItem {
    private Product product ;
    private int quantity ;
    public CartItem (Product product , int quantity){
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct() {
        return this.product;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void setProduct (Product newProduct){
        this.product = newProduct;
    }
    public void setQuantity (int newQuantity){
         this.quantity = newQuantity;
    }
    public double getTotal (){
        return product.getPrice() * quantity;
    }
}
